package pablonuserra.dockertest.service2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pablonuserra.dockertest.service2.model.MessageEntity;
import pablonuserra.dockertest.service2.model.MessageEntityRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class Service2Controller {

    @Autowired
    private MessageEntityRepository messageEntityRepository;

    List<String> messages = new ArrayList<>();

    @GetMapping("/messages")
    public List<MessageEntity> getMessagesHistory(){
        return messageEntityRepository.findAll();
    }

    @KafkaListener(topics = "${kafka.topic.name}")
    public void listenGroup1(String message) {
        messageEntityRepository.save(MessageEntity.builder().message(message).build());
    }
}
