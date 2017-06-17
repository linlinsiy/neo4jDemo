package com.lsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *
 */
@SpringBootApplication
@EntityScan("com.lsy.domain")
public class SampleNeo4jDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleNeo4jDemoApplication.class, args);
	}
}
