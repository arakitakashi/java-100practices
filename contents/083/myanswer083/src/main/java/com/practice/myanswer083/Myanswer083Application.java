package com.practice.myanswer083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Myanswer083Application {

	public static void main(String[] args) {
		SpringApplication.run(Myanswer083Application.class, args);

		MyAnswer myAnswer = new MyAnswer();
		myAnswer.logAnswer("Hello, World!");
	}
}
