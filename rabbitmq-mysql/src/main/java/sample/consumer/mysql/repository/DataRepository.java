package sample.consumer.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.consumer.mysql.entity.MessageDetail;

public interface DataRepository extends JpaRepository<MessageDetail, Long> {

}
