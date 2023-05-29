package br.com.makersweb.hexagonal.architecture.domain.adapters.services;

import br.com.makersweb.hexagonal.architecture.domain.Account;
import br.com.makersweb.hexagonal.architecture.domain.ErrorCode;
import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.CreateAccountCommand;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.SendMoneyCommand;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.converter.AccountServiceConverter;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.AccountServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.TransferMoneyServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.AccountRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

/**
 * @author aaristides
 */
@Slf4j
@Validated
@AllArgsConstructor
public class AccountServiceImpl implements AccountServicePort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final TransferMoneyServicePort transferMoneyServicePort;

    @Override
    public Account retrieveAccountById(UUID id) {
        log.info("Retrieve account by id : {}", id);
        return this.accountRepositoryPort.findById(id)
                .orElseThrow(() -> ErrorCode.ACCOUNT_NOT_FOUND.asErrorResult(id));
    }

    @Override
    public List<Account> retrieveAccounts() {
        log.info("Retrieve all accounts ");
        return this.accountRepositoryPort.findAll();
    }

    @Override
    public Account create(CreateAccountCommand command) {
        log.info("Create account by command : {}", command);
        return this.accountRepositoryPort.save(AccountServiceConverter.toInsertCommand(command));
    }

    @Override
    public void delete(UUID id) {
        log.info("Delete account by id : {}", id);
        this.accountRepositoryPort.delete(id);
    }

    @Override
    public Transfer transferMoney(SendMoneyCommand command) {
        log.info("Transfer money with command : {}", command);
        return this.transferMoneyServicePort.transferMoney(command);
    }
}
