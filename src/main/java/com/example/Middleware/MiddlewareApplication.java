package com.example.Middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiddlewareApplication {

	@GetMapping("/")
	public String sayHello(){
		return "Hallo Niclas";
	}

	@GetMapping("/hello")
	public String sayNext(){
		return "Junge das ist next Level";
	}

	@GetMapping("/hello/{parameter}")
	public String sayParameter(@PathVariable String parameter){
		return "Hello, das ist der Rest Call mit dem Parameter: "+parameter;
	}
	


	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
