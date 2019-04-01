package sample.mongo.mongodocker.mapper;

import org.springframework.stereotype.Component;

import sample.mongo.mongodocker.entity.MessageDetail;
import sample.mongo.mongodocker.model.DataModel;

@Component
public class DataMappper {

	public DataModel getModelFromEntity(MessageDetail messageDetail) {
		DataModel dataModel = new DataModel();
		dataModel.setContent(messageDetail.getContent());
		dataModel.setId(messageDetail.get_id().toString());
		dataModel.setUserId(messageDetail.getUserId());
		return dataModel;
	}

	public MessageDetail getEntityFromModel(DataModel dataModel) {
		MessageDetail messageDetail =  new MessageDetail(dataModel.getContent(),dataModel.getUserId());
		if(dataModel.getId()!=null && !dataModel.getId().isEmpty()) {
			messageDetail.set_id(dataModel.getId());
		}
		return messageDetail;
	}

}
