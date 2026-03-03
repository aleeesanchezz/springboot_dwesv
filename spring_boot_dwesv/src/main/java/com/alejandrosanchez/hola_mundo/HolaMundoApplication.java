package com.alejandrosanchez.hola_mundo;

import com.alejandrosanchez.hola_mundo.models.Cita;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class HolaMundoApplication {

	private static final Logger log = LoggerFactory.getLogger(HolaMundoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoApplication.class, args);
	}

	@Bean
	public ApplicationRunner ejecutar(RestClient.Builder builder) {
		RestClient restClient = builder.baseUrl("http://localhost:8080").build();
		return args -> {
			Cita cita = restClient
					.get().uri("/api/cita")
					.retrieve()
					.body(Cita.class);
			log.info(cita.toString());
		};
	}
}
