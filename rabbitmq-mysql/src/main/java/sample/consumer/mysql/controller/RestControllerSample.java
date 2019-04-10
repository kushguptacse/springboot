package sample.consumer.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sample.consumer.mysql.model.DataModel;
import sample.consumer.mysql.service.MessageDetailService;

@RestController
public class RestControllerSample {

	@Autowired
	private MessageDetailService messageDetailService;
	
	@GetMapping()
	public String getrequest() {
		return "hello";
	}
	
	@GetMapping("/data/{id}")
	public DataModel getById(@PathVariable String id) {
		return messageDetailService.getData(Long.valueOf(id));
	}
	
}
