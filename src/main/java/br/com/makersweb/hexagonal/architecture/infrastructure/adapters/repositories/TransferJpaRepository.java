package br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories;

import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author aaristides
 */
@Repository
public interface TransferJpaRepository extends JpaRepository<TransferEntity, UUID> {
}
