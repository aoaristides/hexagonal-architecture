package br.com.makersweb.hexagonal.architecture.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

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
public class MoneyTransferRequestDTO {

    @NotNull
    private String senderAccountId;
    @NotNull
    private String receiverAccountId;
    @NotNull
    private BigDecimal amount;

}
