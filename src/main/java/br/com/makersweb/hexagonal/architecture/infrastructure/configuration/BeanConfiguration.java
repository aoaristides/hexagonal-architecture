package br.com.makersweb.hexagonal.architecture.infrastructure.configuration;

import br.com.makersweb.hexagonal.architecture.domain.adapters.services.ProductServiceImpl;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.ProductServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.ProductRepositoryPort;
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

}
