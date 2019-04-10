package sample.consumer.mysql.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.consumer.mysql.entity.MessageDetail;
import sample.consumer.mysql.mapper.DataMappper;
import sample.consumer.mysql.model.DataModel;
import sample.consumer.mysql.repository.DataRepository;

@Component
public class MessageDetailService {

	@Autowired
	private DataMappper dataMapper;

	@Autowired
	private DataRepository dataRepository;

	private Long save(DataModel model) {
		MessageDetail messageDetail = dataRepository.save(dataMapper.getEntityFromModel(model));
		return messageDetail.getId();
	}

	public DataModel getData(Long id) {
		DataModel model = null;
		Optional<MessageDetail> optional = dataRepository.findById(id);
		if (optional.isPresent()) {
			model = dataMapper.getModelFromEntity(optional.get());
		}
		return model;
	}

	@Transactional
	@RabbitListener(queues = "${app1.queue.name}")  
	public void receiveMessage(DataModel message) {
		System.out.println("message received : " + message);
		System.out.println("message saved with id : " + save(message));
	}
	


}
