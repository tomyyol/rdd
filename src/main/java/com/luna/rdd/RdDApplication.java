package com.luna.rdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RdDApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdDApplication.class, args);
	}
}
