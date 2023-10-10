package br.com.guilherme.barros.CarsSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CarsSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsSystemApplication.class, args);
	}

}
