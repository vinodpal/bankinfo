package com.fyle_backend_test.bankInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.fyle_backend_test.bankInfo") 
@EnableWebMvc
public class BankInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankInfoApplication.class, args );
	}
}
