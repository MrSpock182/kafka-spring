package io.github.mrspock182.kafka.spring;

import io.github.mrspock182.kafka.spring.dto.User;
import io.github.mrspock182.kafka.spring.messaging.MessagingProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSpringApplication implements CommandLineRunner {

	private final MessagingProducer messaging;

	public KafkaSpringApplication(MessagingProducer messaging) {
		this.messaging = messaging;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Kleber");
		user.setCity("Barueri");

		messaging.send(user);
	}
}
