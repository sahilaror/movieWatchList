package com.example.demo.curds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class WatchListApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchListApplication.class, args);
	}

}
