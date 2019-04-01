package sample.mongo.mongodocker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.mongo.mongodocker.entity.MessageDetail;
import sample.mongo.mongodocker.mapper.DataMappper;
import sample.mongo.mongodocker.model.DataModel;
import sample.mongo.mongodocker.repository.DataRepository;

@Service
public class MessageDetailService {

	@Autowired
	private DataMappper dataMapper;

	@Autowired
	private DataRepository dataRepository;

	@Transactional
	public void save(DataModel model) {
		dataRepository.save(dataMapper.getEntityFromModel(model));
	}

	public DataModel getData(String id) {
		DataModel model = null;
		Optional<MessageDetail> optional = dataRepository.findById(id);
		if (optional.isPresent()) {
			model = dataMapper.getModelFromEntity(optional.get());
		}
		return model;
	}

}
