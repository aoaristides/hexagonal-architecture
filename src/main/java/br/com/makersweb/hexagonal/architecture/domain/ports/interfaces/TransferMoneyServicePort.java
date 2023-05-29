package br.com.makersweb.hexagonal.architecture.domain.ports.interfaces;

import br.com.makersweb.hexagonal.architecture.domain.Transfer;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.command.SendMoneyCommand;
import jakarta.validation.Valid;


/**
 * @author aaristides
 */
public interface TransferMoneyServicePort {

    Transfer transferMoney(@Valid final SendMoneyCommand command);

}
