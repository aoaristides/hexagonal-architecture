package br.com.makersweb.hexagonal.architecture.domain;

import br.com.makersweb.hexagonal.architecture.domain.enums.TransferResult;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * @author aaristides
 */
@Value
@Builder
public class Transfer {

    private UUID id;
    private String senderAccountId;
    private String receiverAccountId;
    private BigDecimal amount;
    private TransferResult result;
    private String detail;
    private Instant createdAt;

}
