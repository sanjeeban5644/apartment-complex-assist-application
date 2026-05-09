package com.sanjeeban.NotificationAndDocumentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class NotificationAndDocumentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationAndDocumentServiceApplication.class, args);
	}

}
