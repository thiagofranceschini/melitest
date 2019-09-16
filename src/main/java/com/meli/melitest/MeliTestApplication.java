package com.meli.melitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MeliTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeliTestApplication.class, args);
	}

}
