package pablonuserra.dockertest.service1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Entity1")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entity1 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
