package pablonuserra.dockertest.service1.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostgresEntityRepository extends CrudRepository<PostgresEntity, Long> {

    Optional<PostgresEntity> findById(Long id);
}
