package br.com.makersweb.hexagonal.architecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.Instant;
import java.util.UUID;

/**
 * @author aaristides
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private UUID id;
    private String accountId;
    private String name;
    private String owner;
    private BigInteger balance;
    private Instant createdAt;

    public void withDraw(final BigInteger money) {
        this.setBalance(this.getBalance().subtract(money));
    }

    public void deposit(final BigInteger money) {
        this.setBalance(this.getBalance().add(money));
    }

}
