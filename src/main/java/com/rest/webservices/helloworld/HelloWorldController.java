package com.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {

		// return instance of hello-world-bean class
		return new HelloWorldBean("Hello World!");
	}

	@GetMapping(path = "/hello-world/pathvariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

		// passing path value
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
