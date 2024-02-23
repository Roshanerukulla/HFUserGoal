package com.hf.goaluser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HfGoalsUserMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfGoalsUserMappingApplication.class, args);
	}

}
