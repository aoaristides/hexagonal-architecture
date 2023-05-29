package br.com.makersweb.hexagonal.architecture.application.adapters.controllers;

import br.com.makersweb.hexagonal.architecture.domain.adapters.services.converter.AccountApiConverter;
import br.com.makersweb.hexagonal.architecture.domain.dtos.MoneyTransferRequestDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.MoneyTransferResponseDTO;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.AccountServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("accounts/transfer")
public class MoneyTransferController {

    private final AccountServicePort accountServicePort;

    @PostMapping
    @ResponseStatus(CREATED)
    public MoneyTransferResponseDTO transferMoney(@RequestBody final MoneyTransferRequestDTO request) {
        log.info("Transfer money with request : {}", request);
        return AccountApiConverter.toMoneyTransferResponse(this.accountServicePort.transferMoney(AccountApiConverter.toCommand(request)));
    }

}
