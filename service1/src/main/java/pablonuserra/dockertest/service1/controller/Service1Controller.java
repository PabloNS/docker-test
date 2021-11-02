package pablonuserra.dockertest.service1.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pablonuserra.dockertest.service1.model.PostgresEntity;
import pablonuserra.dockertest.service1.model.PostgresEntityRepository;
import pablonuserra.dockertest.service1.service.Service1Service;

@RestController
@Slf4j
public class Service1Controller {

    Logger logger = LoggerFactory.getLogger(Service1Controller.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PostgresEntityRepository entity1Repository;

    @Autowired
    private Service1Service service1Service;

    @Value("${kafka.topic.name}")
    private String topicName;

    int messagesCount = 0;

    int entityCount = 0;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        kafkaTemplate.send(topicName, "Message sent from service1 #" + ++messagesCount);
        return "Message sent!";
    }

    @PostMapping("/entity")
    public PostgresEntity createEntity(){
        PostgresEntity entity1 = PostgresEntity.builder().name("Entity" + ++entityCount).build();
        entity1Repository.save(entity1);
        return entity1;
    }

    @GetMapping("/entity/{id}")
    public PostgresEntity getEntity(@PathVariable("id") Long id){
        return service1Service.getEntity(id);
    }
}
