package br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories;

import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author aaristides
 */
@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {

    Optional<AccountEntity> findByAccountId(final String accountId);

}
