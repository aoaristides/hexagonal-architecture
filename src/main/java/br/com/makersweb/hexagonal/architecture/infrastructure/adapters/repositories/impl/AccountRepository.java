package br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.impl;

import br.com.makersweb.hexagonal.architecture.domain.Account;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.AccountRepositoryPort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.UpdateAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.converter.RepositoryConverter;
import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.AccountJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static br.com.makersweb.hexagonal.architecture.domain.ports.repositories.converter.RepositoryConverter.toAccount;
import static br.com.makersweb.hexagonal.architecture.domain.ports.repositories.converter.RepositoryConverter.toAccountEntity;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
@Component
public class AccountRepository implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public List<Account> findAll() {
        log.info("Find all accounts ");
        return accountJpaRepository.findAll().stream()
                .map(RepositoryConverter::toAccount)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findById(final UUID id) {
        log.info("Find account by id : {}", id);
        return accountJpaRepository.findById(id)
                .map(RepositoryConverter::toAccount);
    }

    @Override
    public Optional<Account> findByAccountId(final String accountId) {
        log.info("Find account by accountID : {}", accountId);
        return accountJpaRepository.findByAccountId(accountId)
                .map(RepositoryConverter::toAccount);
    }

    @Override
    public Account update(final UpdateAccountCommand command) {
        log.info("Update account by command : {}", command);
        return toAccount(accountJpaRepository.save(toAccountEntity(command)));
    }

    @Override
    public Account save(final InsertAccountCommand command) {
        log.info("Save account by command : {}", command);
        return toAccount(accountJpaRepository.save(toAccountEntity(command)));
    }

    @Override
    public void delete(final UUID id) {
        log.info("Delete account by id : {}", id);
        accountJpaRepository.deleteById(id);
    }

}
