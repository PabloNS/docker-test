package pablonuserra.dockertest.service1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pablonuserra.dockertest.service1.model.PostgresEntity;
import pablonuserra.dockertest.service1.model.PostgresEntityRepository;

@Service
public class Service1Service {

    Logger logger = LoggerFactory.getLogger(Service1Service.class);

    @Autowired
    private PostgresEntityRepository entity1Repository;

    public PostgresEntity getEntity(Long id){
        return entity1Repository.findById(id).orElseGet(() -> {
            logger.error("Entity1 with id {} doesn't exist", id);
            return null; });
    }
}
