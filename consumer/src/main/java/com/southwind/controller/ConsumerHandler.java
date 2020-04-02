package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerHandler {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        ResponseEntity<Collection> responseEntity=restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class);
        //System.out.println("============="+responseEntity.toString()+"====="+responseEntity.getBody());
        return responseEntity.getBody();
    }
    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    // @DeleteMapping("/deleteById/{id}") 只能用postman的deleteMapping(post提交，不支持GET提交，也就是地址栏中不能有参数)
    @RequestMapping("/deleteById/{id}")
    public void deleteByid(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/"+id,id);
    }
}
