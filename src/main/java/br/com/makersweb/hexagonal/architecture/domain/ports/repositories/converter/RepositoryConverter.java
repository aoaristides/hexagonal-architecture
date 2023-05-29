package br.com.makersweb.hexagonal.architecture.domain.ports.repositories.converter;

import br.com.makersweb.hexagonal.architecture.domain.Account;
import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertTransferCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.UpdateAccountCommand;
import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.entity.AccountEntity;
import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.entity.TransferEntity;
import lombok.experimental.UtilityClass;

import java.time.Instant;

/**
 * @author aaristides
 */
@UtilityClass
public class RepositoryConverter {

    public static TransferEntity toTransferEntity(final InsertTransferCommand command) {
        return TransferEntity.builder()
                .amount(command.getAmount())
                .senderAccountId(command.getSenderAccountId())
                .receiverAccountId(command.getReceiverAccountId())
                .result(command.getResult())
                .detail(command.getDetail())
                .createdAt(Instant.now())
                .build();
    }

    public static Transfer toTransfer(final TransferEntity entity) {
        return Transfer.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .senderAccountId(entity.getSenderAccountId())
                .receiverAccountId(entity.getReceiverAccountId())
                .result(entity.getResult())
                .detail(entity.getDetail())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static Account toAccount(final AccountEntity entity) {
        var account = new Account();
        account.setId(entity.getId());
        account.setBalance(entity.getBalance());
        account.setName(entity.getName());
        account.setOwner(entity.getOwner());
        account.setAccountId(entity.getAccountId());
        account.setCreatedAt(entity.getCreatedAt());
        return account;
    }

    public static AccountEntity toAccountEntity(final UpdateAccountCommand command) {
        return AccountEntity.builder()
                .id(command.getId())
                .balance(command.getBalance())
                .name(command.getName())
                .owner(command.getOwner())
                .accountId(command.getAccountId())
                .createdAt(Instant.now())
                .build();
    }

    public static AccountEntity toAccountEntity(final InsertAccountCommand command) {
        return AccountEntity.builder()
                .balance(command.getBalance())
                .name(command.getName())
                .owner(command.getOwner())
                .accountId(command.getAccountId())
                .createdAt(Instant.now())
                .build();
    }

}
