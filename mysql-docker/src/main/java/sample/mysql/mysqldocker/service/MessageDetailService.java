package sample.mysql.mysqldocker.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.mysql.mysqldocker.entity.MessageDetail;
import sample.mysql.mysqldocker.mapper.DataMappper;
import sample.mysql.mysqldocker.model.DataModel;
import sample.mysql.mysqldocker.repository.DataRepository;

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

	public DataModel getData(Long id) {
		DataModel model = null;
		Optional<MessageDetail> optional = dataRepository.findById(id);
		if (optional.isPresent()) {
			model = dataMapper.getModelFromEntity(optional.get());
		}
		return model;
	}

}
