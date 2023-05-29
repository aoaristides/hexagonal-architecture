package br.com.makersweb.hexagonal.architecture.domain.ports.interfaces;

import br.com.makersweb.hexagonal.architecture.domain.Account;
import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.CreateAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.SendMoneyCommand;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

/**
 * @author aaristides
 */
public interface AccountServicePort {

    Account retrieveAccountById(final UUID id);

    List<Account> retrieveAccounts();

    Account create(final @Valid CreateAccountCommand command);

    void delete(final UUID id);

    Transfer transferMoney(@Valid final SendMoneyCommand command);

}
