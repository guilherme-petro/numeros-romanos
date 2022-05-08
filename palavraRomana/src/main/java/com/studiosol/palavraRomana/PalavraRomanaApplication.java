package com.studiosol.palavraRomana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class PalavraRomanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalavraRomanaApplication.class, args);
	}

}
