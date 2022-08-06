package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EKisanMandiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EKisanMandiApplication.class, args);
	}

	// configure ModelMapper as a spring bean
	@Bean // equivalent to <bean> tag in xml file
	public ModelMapper mapper() {
		System.out.println("in mapper");
		return new ModelMapper();
	}

}
