package sample.mysql.mysqldocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sample.mysql.mysqldocker.model.DataModel;
import sample.mysql.mysqldocker.service.MessageDetailService;

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
	
	@PostMapping("/data") 
	public String postData(@RequestBody DataModel model) {
		messageDetailService.save(model);
		return "successfully posted";
		
	}
	
	
}
