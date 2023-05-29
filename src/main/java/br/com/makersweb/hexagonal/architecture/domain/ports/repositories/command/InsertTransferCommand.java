package br.com.makersweb.hexagonal.architecture.domain.ports.repositories.command;

import br.com.makersweb.hexagonal.architecture.domain.enums.TransferResult;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aaristides
 */
@Value
@Builder
@With
public class InsertTransferCommand {

    private String senderAccountId;
    private String receiverAccountId;
    private BigDecimal amount;
    private TransferResult result;
    private String detail;
    private Instant createdAt;

}
