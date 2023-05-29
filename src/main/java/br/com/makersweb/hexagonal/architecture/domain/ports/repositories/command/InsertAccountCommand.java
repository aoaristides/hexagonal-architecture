package br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigInteger;

/**
 * @author aaristides
 */
@Value
@Builder
@With
public class InsertAccountCommand {

    private String accountId;
    private String name;
    private String owner;
    private BigInteger balance;

}
