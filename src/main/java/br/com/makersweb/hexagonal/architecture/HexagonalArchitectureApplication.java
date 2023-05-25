package br.com.makersweb.hexagonal.architecture;

import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.PostgreSqlProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PostgreSqlProductRepository.class)
public class HexagonalArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

}
