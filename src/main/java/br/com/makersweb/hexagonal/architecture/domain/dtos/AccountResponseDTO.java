package br.com.makersweb.hexagonal.architecture.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigInteger;
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
public class AccountResponseDTO {

    private UUID id;
    private String accountId;
    private String name;
    private String owner;
    private BigInteger balance;
    private Instant createdAt;

}
