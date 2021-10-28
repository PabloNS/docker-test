package pablonuserra.dockertest.service1.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Entity1Repository extends CrudRepository<Entity1, Long> {

    Optional<Entity1> findById(Long id);
}
