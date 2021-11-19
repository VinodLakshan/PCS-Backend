package com.esoft.pcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class PcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcsApplication.class, args);
	}

}
