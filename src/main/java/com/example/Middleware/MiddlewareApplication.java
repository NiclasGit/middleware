package com.example.Middleware;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import ch.qos.logback.classic.Logger;

@SpringBootApplication
@RestController
public class MiddlewareApplication {

	//private Logger logger = LoggerFactory.getLogger(MiddlewareApplication.class);


	@Autowired
	TodoRepository repo;

	@Value("${my.property:unset}")
	String internalProperty;

	ArrayList<String> userList = new ArrayList<String>(List.of("Niclas","Lukas"));
	

	@PostMapping("/setProperty/{paramProperty}")
	public String setProperty(@PathVariable String paramProperty){
		//logger.info("Old property{} New Property {}", internalProperty, paramProperty);
		return internalProperty;
	}


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
	
	@PostMapping("/todo/{todo}")
	public String createTodo(@PathVariable String todo){
		Todo newTodo = new Todo();
		newTodo.todo = todo;
		repo.save(newTodo);
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
