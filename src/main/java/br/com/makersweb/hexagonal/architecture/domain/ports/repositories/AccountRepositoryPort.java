package br.com.makersweb.hexagonal.architecture.domain.ports.repositories;

import br.com.makersweb.hexagonal.architecture.domain.Account;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.UpdateAccountCommand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author aaristides
 */
public interface AccountRepositoryPort {

    List<Account> findAll();

    Optional<Account> findById(final UUID id);

    Optional<Account> findByAccountId(final String accountId);

    Account update(final UpdateAccountCommand command);

    Account save(final InsertAccountCommand command);

    void delete(final UUID id);

}
