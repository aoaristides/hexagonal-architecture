package br.com.makersweb.hexagonal.architecture.domain.ports.repositories;

import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command.InsertTransferCommand;

/**
 * @author aaristides
 */
public interface TransferRepositoryPort {

    Transfer save(final InsertTransferCommand command);

}
