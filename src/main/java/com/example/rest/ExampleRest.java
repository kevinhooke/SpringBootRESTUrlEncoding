package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ExampleResult;

/**
 * Example REST Controller. Supports a simple GET and a GET with path params.
 * 
 * @author kevinhooke
 *
 */
@RestController
public class ExampleRest {

	@GetMapping("/example1")
	public ExampleResult example1(){
		ExampleResult result = new ExampleResult();
		result.setValue("GET with no path param");
		return result;
	}

	@GetMapping("/example1/{param1}")
	public ExampleResult example2(@PathVariable String param1){
		System.out.println("In controller, param: " + param1);
		ExampleResult result = new ExampleResult();
		result.setValue(param1);
		return result;
	}
}
