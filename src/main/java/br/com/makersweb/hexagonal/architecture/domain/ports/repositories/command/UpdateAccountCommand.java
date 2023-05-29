package br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigInteger;
import java.util.UUID;

/**
 * @author aaristides
 */
@Value
@Builder
@With
public class UpdateAccountCommand {

    private UUID id;
    private String accountId;
    private String name;
    private String owner;
    private BigInteger balance;

}
