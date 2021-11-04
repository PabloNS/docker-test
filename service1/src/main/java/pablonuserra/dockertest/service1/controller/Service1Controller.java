package pablonuserra.dockertest.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pablonuserra.dockertest.service1.model.PostgresEntity;
import pablonuserra.dockertest.service1.service.Service1Service;

@RestController
public class Service1Controller {

    @Autowired
    private Service1Service service1Service;

    @PostMapping("/sendMessage")
    public String sendMessage(){
        return service1Service.sendMessage();
    }

    @PostMapping("/entity")
    public PostgresEntity createEntity(){
        return service1Service.createEntity();
    }

    @GetMapping("/entity/{id}")
    public PostgresEntity getEntity(@PathVariable("id") Long id){
        return service1Service.getEntity(id);
    }
}
