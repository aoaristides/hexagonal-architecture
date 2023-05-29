package br.com.makersweb.hexagonal.architecture.domain.adapters.services.command;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

/**
 * @author aaristides
 */
@Value
@Builder
public class SendMoneyCommand {

    @NotNull
    private String senderAccountId;
    @NotNull
    private String receiverAccountId;
    @NotNull
    private BigDecimal amount;

}
