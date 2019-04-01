package sample.rabbitmqconsumerdocker.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import sample.rabbitmqconsumerdocker.model.DataModel;

@Component
public class MessageDetailService {
	@RabbitListener(queues = "${app1.queue.name}")  
	public void receiveMessage(DataModel message) {
		
		System.out.println("message received " + message);
		
	}

}
