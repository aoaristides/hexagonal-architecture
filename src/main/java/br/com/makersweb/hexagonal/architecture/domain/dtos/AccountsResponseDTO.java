package br.com.makersweb.hexagonal.architecture.domain.dtos;

import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * @author aaristides
 */
@Value
@Builder
public class AccountsResponseDTO {

    List<AccountResponseDTO> accounts;

}
