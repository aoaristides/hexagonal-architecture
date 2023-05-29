package br.com.makersweb.hexagonal.architecture.domain.dtos;

import br.com.makersweb.hexagonal.architecture.domain.enums.TransferResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * @author aaristides
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferResponseDTO {

    private UUID id;
    private String senderAccountId;
    private String receiverAccountId;
    private BigDecimal amount;
    private TransferResult result;
    private Instant timeStamp;

}
