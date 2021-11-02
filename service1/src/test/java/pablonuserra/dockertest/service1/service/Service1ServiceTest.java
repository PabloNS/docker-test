package pablonuserra.dockertest.service1.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pablonuserra.dockertest.service1.model.PostgresEntity;
import pablonuserra.dockertest.service1.model.PostgresEntityRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Service1ServiceTest {

    @Mock
    private PostgresEntityRepository postgresEntityRepository;

    @InjectMocks
    private Service1Service service1Service;

    @Test
    public void entityNotFoundShouldReturnNull(){
        when(postgresEntityRepository.findById(any())).thenReturn(Optional.empty());
        assertEquals(null, service1Service.getEntity(1l));
    }

    @Test
    public void entityFoundShouldReturnFoundEntity(){
        PostgresEntity postgresEntity = Mockito.mock(PostgresEntity.class);
        when(postgresEntityRepository.findById(any())).thenReturn(Optional.ofNullable(postgresEntity));
        assertEquals(postgresEntity, service1Service.getEntity(1l));
    }
}
