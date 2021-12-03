package com.example.Middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiddlewareApplication {

	@GetMapping("/")
	public String sayHello(){

		return "Hello, HfT Stuttgart !!";
	}

	@GetMapping("/hello")
	public String sayHelloAgain(){

		return "Hallo Niclas";
	}

	@GetMapping("/hello/{parameter}")
	public String sayHelloWithParameter(@PathVariable String parameter){

		return "Hallo, das ist der APICall mit Paramter "+parameter;
	}

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
