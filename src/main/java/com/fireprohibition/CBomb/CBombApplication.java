package com.fireprohibition.CBomb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CBombApplication {

	public static void main(String[] args) {
		SpringApplication.run(CBombApplication.class, args);
	}
}
