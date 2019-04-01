package sample.rabbitmqconsumerdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerSample {

	@GetMapping()
	public String getrequest() {
		return "hello";
	}
	
}
