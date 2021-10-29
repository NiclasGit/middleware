package com.example.Middleware;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiddlewareApplication {

	ArrayList<String> userList = new ArrayList<String>(List.of("Niclas","Lukas"));
	

	

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

	@GetMapping("/users")
	public ArrayList<String> giveUsers(){
		return userList;
	}

	@RequestMapping("/users/{parameter}")
	public String addUser(@PathVariable String parameter){
		userList.add(parameter);
		return "User "+ parameter+" wurde zu er Userliste hinzugefügt";
		
	}
	


	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
