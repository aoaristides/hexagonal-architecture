package br.com.makersweb.hexagonal.architecture.domain.exceptions;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @author aaristides
 */
@Value
@EqualsAndHashCode(callSuper = true)
@Builder
public class ErrorResultException extends RuntimeException {

    private String type;
    private String code;
    private String message;
    private int status;

}
