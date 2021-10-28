package pablonuserra.dockertest.service2.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class MessageEntity {

    @Id
    private String id;
    private String message;
}
