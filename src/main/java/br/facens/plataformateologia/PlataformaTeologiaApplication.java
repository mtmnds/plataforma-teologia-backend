package br.facens.plataformateologia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlataformaTeologiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaTeologiaApplication.class, args);
	}

}
