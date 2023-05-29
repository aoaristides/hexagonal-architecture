package br.com.makersweb.hexagonal.architecture.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;

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
public class AccountRequestDTO {

    @NotNull
    private String accountId;
    @NotNull
    private String name;
    @NotNull
    private String owner;
    private BigInteger balance;

}
