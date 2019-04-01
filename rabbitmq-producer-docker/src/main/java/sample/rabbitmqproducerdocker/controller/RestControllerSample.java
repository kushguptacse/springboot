package sample.rabbitmqproducerdocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sample.rabbitmqproducerdocker.controller.model.DataModel;
import sample.rabbitmqproducerdocker.controller.service.MessageDetailService;

@RestController
public class RestControllerSample {

	@Autowired
	private MessageDetailService messageDetailService;
	
	@GetMapping()
	public String getrequest() {
		return "hello";
	}
	
	@PostMapping("/data") 
	public String postData(@RequestBody DataModel model) {
		messageDetailService.save(model);
		return "successfully posted";
		
	}
	
	
}
