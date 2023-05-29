package br.com.makersweb.hexagonal.architecture.infrastructure.configuration;

import br.com.makersweb.hexagonal.architecture.domain.adapters.services.AccountServiceImpl;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.ProductServiceImpl;
import br.com.makersweb.hexagonal.architecture.domain.adapters.services.TransferMoneyServiceImpl;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.AccountServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.ProductServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.TransferMoneyServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.AccountRepositoryPort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.ProductRepositoryPort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.TransferRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class BeanConfiguration {

    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductServiceImpl(productRepositoryPort);
    }

    @Bean
    TransferMoneyServicePort transferMoneyService(TransferRepositoryPort transferRepositoryPort, AccountRepositoryPort accountRepositoryPort) {
        return new TransferMoneyServiceImpl(transferRepositoryPort, accountRepositoryPort);
    }

    @Bean
    AccountServicePort accountService(AccountRepositoryPort accountRepositoryPort, TransferMoneyServicePort transferMoneyServicePort) {
        return new AccountServiceImpl(accountRepositoryPort, transferMoneyServicePort);
    }

}
