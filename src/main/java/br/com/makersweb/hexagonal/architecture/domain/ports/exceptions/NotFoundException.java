package br.com.makersweb.hexagonal.architecture.domain.ports.exceptions;

/**
 * @author aaristides
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
