package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.reposity.StudentReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    private StudentReposity studentReposity;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return  studentReposity.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentReposity.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentReposity.saveOrUpdate(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentReposity.saveOrUpdate(student);
    }

   // @DeleteMapping("/deleteById/{id}") 只能用postman的deleteMapping(post提交，不支持GET提交，也就是地址栏中不能有参数)
    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentReposity.deleteById(id);
    }

    @GetMapping("/index")
    public String index() {
        return "当前端口："+this.port;
    }
}
