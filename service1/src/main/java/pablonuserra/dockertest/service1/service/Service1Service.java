package pablonuserra.dockertest.service1.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pablonuserra.dockertest.service1.model.PostgresEntity;
import pablonuserra.dockertest.service1.model.PostgresEntityRepository;

@Service
@Slf4j
public class Service1Service {

    Logger logger = LoggerFactory.getLogger(Service1Service.class);

    @Autowired
    private PostgresEntityRepository entity1Repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    int messagesCount = 0;

    int entityCount = 0;

    public String sendMessage(){
        kafkaTemplate.send(topicName, "Message sent from service1 #" + ++messagesCount);
        return "Message sent!";
    }

    @Cacheable(value = "postGresEntityCache")
    public PostgresEntity getEntity(Long id){
        logger.info("NOT CACHED YET!");
        return entity1Repository.findById(id).orElseGet(() -> {
            logger.error("Entity1 with id {} doesn't exist", id);
            return null; });
    }

    public PostgresEntity createEntity(){
        PostgresEntity entity1 = PostgresEntity.builder().name("Entity" + ++entityCount).build();
        entity1Repository.save(entity1);
        return entity1;
    }
}
