package com.Marcio.Salao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/")
public class SalaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaoApplication.class, args);
	}

}
