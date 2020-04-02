package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("localhost:8010/student/findAll",Collection.class).getBody();
    }
    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("localhost:8010/student/findAll",Collection.class);
    }

   // @DeleteMapping("/deleteById/{id}")
    @GetMapping("/deleteById/{id}")
    public void deleteByid(@PathVariable("id") long id){
        restTemplate.delete("localhost:8010/student/deleteById/{id}",id);
    }
}
