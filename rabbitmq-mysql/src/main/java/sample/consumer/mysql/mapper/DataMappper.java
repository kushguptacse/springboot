package sample.consumer.mysql.mapper;

import org.springframework.stereotype.Component;

import sample.consumer.mysql.entity.MessageDetail;
import sample.consumer.mysql.model.DataModel;

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
