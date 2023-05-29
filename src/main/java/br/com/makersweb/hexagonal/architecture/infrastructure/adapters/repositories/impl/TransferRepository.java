package br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.impl;

import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.TransferRepositoryPort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertTransferCommand;
import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.TransferJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static br.com.makersweb.hexagonal.architecture.domain.ports.repositories.converter.RepositoryConverter.toTransfer;
import static br.com.makersweb.hexagonal.architecture.domain.ports.repositories.converter.RepositoryConverter.toTransferEntity;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
@Component
public class TransferRepository implements TransferRepositoryPort {

    private final TransferJpaRepository transferJpaRepository;

    @Override
    public Transfer save(InsertTransferCommand command) {
        log.info("Save money transfer with command : {}", command);
        return toTransfer(transferJpaRepository.save(toTransferEntity(command)));
    }
}
