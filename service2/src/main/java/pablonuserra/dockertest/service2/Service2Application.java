package pablonuserra.dockertest.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Service2Application {

	List<String> messages = new ArrayList<>();

	@GetMapping
	public String helloWorld(){
		return "Hello World from service2!";
	}

	@GetMapping("/messages")
	public String getMessagesHistory(){
		return messages.toString();
	}

	@KafkaListener(topics = "topic1", groupId = "group1")
	public void listenGroup1(String message) {
		messages.add(message);
	}

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
}
