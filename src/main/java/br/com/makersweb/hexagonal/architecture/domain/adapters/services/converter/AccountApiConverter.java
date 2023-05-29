package br.com.makersweb.hexagonal.architecture.domain.adapters.services.converter;

import br.com.makersweb.hexagonal.architecture.domain.Account;
import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.CreateAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.SendMoneyCommand;
import br.com.makersweb.hexagonal.architecture.domain.dtos.AccountRequestDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.AccountResponseDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.MoneyTransferRequestDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.MoneyTransferResponseDTO;
import lombok.experimental.UtilityClass;

/**
 * @author aaristides
 */
@UtilityClass
public class AccountApiConverter {

    public static MoneyTransferResponseDTO toMoneyTransferResponse(final Transfer transfer) {
        return MoneyTransferResponseDTO.builder()
                .id(transfer.getId())
                .senderAccountId(transfer.getSenderAccountId())
                .receiverAccountId(transfer.getReceiverAccountId())
                .amount(transfer.getAmount())
                .timeStamp(transfer.getCreatedAt())
                .result(transfer.getResult())
                .build();
    }

    public static AccountResponseDTO toAccountResponse(final Account account) {
        return AccountResponseDTO.builder()
                .id(account.getId())
                .accountId(account.getAccountId())
                .name(account.getName())
                .owner(account.getOwner())
                .balance(account.getBalance())
                .createdAt(account.getCreatedAt())
                .build();
    }

    public static SendMoneyCommand toCommand(final MoneyTransferRequestDTO request) {
        return SendMoneyCommand.builder()
                .senderAccountId(request.getSenderAccountId())
                .receiverAccountId(request.getReceiverAccountId())
                .amount(request.getAmount())
                .build();
    }

    public static CreateAccountCommand toCreateAccountCommand(final AccountRequestDTO request) {
        return CreateAccountCommand.builder()
                .accountId(request.getAccountId())
                .name(request.getName())
                .owner(request.getOwner())
                .balance(request.getBalance())
                .build();
    }

}
