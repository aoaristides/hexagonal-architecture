package br.com.makersweb.hexagonal.architecture.domain.adapters.services.converter;

import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.CreateAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertAccountCommand;
import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.Optional;

/**
 * @author aaristides
 */
@UtilityClass
public class AccountServiceConverter {

    public static InsertAccountCommand toInsertCommand(final CreateAccountCommand command) {
        return InsertAccountCommand.builder()
                .accountId(command.getAccountId())
                .name(command.getName())
                .owner(command.getOwner())
                .balance(Optional.ofNullable(command.getBalance())
                        .orElse(BigInteger.ZERO))
                .build();
    }

}
