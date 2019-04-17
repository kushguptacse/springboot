package sample.mysql.mysqldocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.mysql.mysqldocker.entity.MessageDetail;

public interface DataRepository extends JpaRepository<MessageDetail, Long> {

}
