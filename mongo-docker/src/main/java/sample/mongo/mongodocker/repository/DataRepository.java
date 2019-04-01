package sample.mongo.mongodocker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sample.mongo.mongodocker.entity.MessageDetail;

public interface DataRepository extends MongoRepository<MessageDetail, String> {

}
