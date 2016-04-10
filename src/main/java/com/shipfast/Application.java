package com.shipfast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class Application {
	@Autowired
	private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Services services() {
		return new Services(environment);
	}

	@Configuration
	public static class LocalConfig {

	}

	@Configuration
	@Profile("docker")
	public static class DockerConfig {

	}
}
