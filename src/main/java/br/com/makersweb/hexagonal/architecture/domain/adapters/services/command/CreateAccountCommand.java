package br.com.makersweb.hexagonal.architecture.domain.adapters.services.command;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;

/**
 * @author aaristides
 */
@Value
@Builder
public class CreateAccountCommand {

    @NotNull
    private String accountId;
    @NotNull
    private String name;
    @NotNull
    private String owner;
    private BigInteger balance;

}
