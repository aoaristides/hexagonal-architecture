package br.com.makersweb.hexagonal.architecture.domain.adapters.services;

import br.com.makersweb.hexagonal.architecture.domain.ErrorCode;
import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.SendMoneyCommand;
import br.com.makersweb.hexagonal.architecture.domain.enums.TransferResult;
import br.com.makersweb.hexagonal.architecture.domain.exceptions.ErrorResultException;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.TransferMoneyServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.AccountRepositoryPort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.TransferRepositoryPort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertTransferCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.UpdateAccountCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

/**
 * @author aaristides
 */
@Slf4j
@Validated
@AllArgsConstructor
public class TransferMoneyServiceImpl implements TransferMoneyServicePort {

    private final TransferRepositoryPort transferRepositoryPort;
    private final AccountRepositoryPort accountRepositoryPort;

    @Override
    public Transfer transferMoney(SendMoneyCommand command) {
        log.info("Transfer money with command : {}", command);
        try {
            var sender = accountRepositoryPort.findByAccountId(command.getSenderAccountId())
                    .orElseThrow(() -> ErrorCode.SENDER_ACCOUNT_NOT_FOUND.asErrorResult(command.getSenderAccountId()));
            var receiver = accountRepositoryPort.findByAccountId(command.getReceiverAccountId())
                    .orElseThrow(() -> ErrorCode.RECEIVER_ACCOUNT_NOT_FOUND.asErrorResult(command.getSenderAccountId()));

            if (sender.getBalance().compareTo(command.getAmount().toBigInteger()) < 0) {
                throw ErrorCode.NOT_SUFFICIENT_BALANCE.asErrorResult(command.getSenderAccountId());
            }

            sender.withDraw(command.getAmount().toBigInteger());
            receiver.deposit(command.getAmount().toBigInteger());

            accountRepositoryPort.update(UpdateAccountCommand.builder()
                    .balance(sender.getBalance())
                    .id(sender.getId())
                    .name(sender.getName())
                    .owner(sender.getOwner())
                    .accountId(sender.getAccountId())
                    .build());

            accountRepositoryPort.update(UpdateAccountCommand.builder()
                    .balance(receiver.getBalance())
                    .id(receiver.getId())
                    .name(receiver.getName())
                    .owner(receiver.getOwner())
                    .accountId(receiver.getAccountId())
                    .build());

            return transferRepositoryPort.save(InsertTransferCommand.builder()
                    .senderAccountId(command.getSenderAccountId())
                    .receiverAccountId(command.getReceiverAccountId())
                    .amount(command.getAmount())
                    .result(TransferResult.SUCCESSFUL)
                    .build());

        } catch (final ErrorResultException ex) {
            log.error("Transaction failed : {}", ex.getMessage());
            transferRepositoryPort.save(InsertTransferCommand.builder()
                    .senderAccountId(command.getSenderAccountId())
                    .receiverAccountId(command.getReceiverAccountId())
                    .amount(command.getAmount())
                    .result(TransferResult.FAILED)
                    .build());
            throw ex;
        }
    }
}
