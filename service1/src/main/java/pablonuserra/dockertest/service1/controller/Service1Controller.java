package pablonuserra.dockertest.service1.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pablonuserra.dockertest.service1.model.Entity1;
import pablonuserra.dockertest.service1.model.Entity1Repository;

@RestController
@Slf4j
public class Service1Controller {

    Logger logger = LoggerFactory.getLogger(Service1Controller.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Entity1Repository entity1Repository;

    int messagesCount = 0;

    int entityCount = 0;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        kafkaTemplate.send("topic1", "Hello from service1 #" + ++messagesCount);
        return "Message sent!";
    }

    @GetMapping("/createEntity")
    public Entity1 createEntity(){
        Entity1 entity1 = Entity1.builder().name("Entity" + ++entityCount).build();
        entity1Repository.save(entity1);
        return entity1;
    }

    @GetMapping("/getEntity/{id}")
    public Entity1 createEntity(@PathVariable("id") Long id){
        return entity1Repository.findById(id).orElseGet(() -> {
            logger.error("Entity1 with id {} doesn't exist", id);
            return null; });
    }
}
