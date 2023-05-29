package br.com.makersweb.hexagonal.architecture.application.adapters.controllers;

import br.com.makersweb.hexagonal.architecture.domain.adapters.services.converter.AccountApiConverter;
import br.com.makersweb.hexagonal.architecture.domain.dtos.AccountRequestDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.AccountResponseDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.AccountsResponseDTO;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.AccountServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountServicePort accountServicePort;

    @PostMapping
    @ResponseStatus(CREATED)
    public AccountResponseDTO persistAccount(@RequestBody final AccountRequestDTO request) {
        log.info("Persist account by request : {}", request);
        return AccountApiConverter.toAccountResponse(accountServicePort.create(AccountApiConverter.toCreateAccountCommand(request)));
    }

    @GetMapping
    @ResponseStatus(OK)
    public AccountsResponseDTO retrieveAccounts() {
        log.info("Retrieve accounts");
        return AccountsResponseDTO.builder()
                .accounts(accountServicePort.retrieveAccounts().stream()
                        .map(AccountApiConverter::toAccountResponse)
                        .collect(Collectors.toList())
                ).build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public AccountResponseDTO retrieveAccountById(@PathVariable final UUID id) {
        log.info("Retrieve account by id : {}", id);
        return AccountApiConverter.toAccountResponse(accountServicePort.retrieveAccountById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final UUID id) {
        log.info("Delete account by id : {}", id);
        accountServicePort.delete(id);
    }

}
