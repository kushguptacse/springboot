package sample.rabbitmqproducerdocker.controller.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.rabbitmqproducerdocker.config.ApplicationConfigReader;
import sample.rabbitmqproducerdocker.controller.model.DataModel;

@Service
public class MessageDetailService {

	@Autowired
	private ApplicationConfigReader ApplicationConfigReader;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void save(DataModel model) {
		sendMessage(ApplicationConfigReader.getApp1Exchange(), ApplicationConfigReader.getApp1RoutingKey(), model);
	}

	private void sendMessage(String exchange, String routingKey, Object data) {
		rabbitTemplate.convertAndSend(exchange, routingKey, data);
	}

}
