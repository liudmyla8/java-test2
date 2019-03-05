package com.test.javatest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaTest2Application {
	
	protected static int[] currency;

	public static void main(String[] args) {
		SpringApplication.run(JavaTest2Application.class, args);
		currency = CurrencyController.GenCurrency();
	}

}
