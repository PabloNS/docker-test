package pablonuserra.dockertest.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service1Application {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	int messagesCount = 0;

	@GetMapping
	public String helloWorld(){
		return "Hello World from service1!";
	}

	@GetMapping("/sendMessage")
	public String sendMessage(){
		kafkaTemplate.send("topic1", "Hello from service1 #" + ++messagesCount);
		return "Message sent!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
