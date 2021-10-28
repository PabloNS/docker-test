package pablonuserra.dockertest.service2.model;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MessageEntityRepository extends MongoRepository<MessageEntity ,String> {
}
