package sample.mysql.mysqldocker.mapper;

import org.springframework.stereotype.Component;

import sample.mysql.mysqldocker.entity.MessageDetail;
import sample.mysql.mysqldocker.model.DataModel;

@Component
public class DataMappper {

	public DataModel getModelFromEntity(MessageDetail messageDetail) {
		DataModel dataModel = new DataModel();
		dataModel.setContent(messageDetail.getContent());
		dataModel.setId(messageDetail.getId());
		return dataModel;
	}

	public MessageDetail getEntityFromModel(DataModel dataModel) {
		return new MessageDetail(dataModel.getContent());

	}

}
