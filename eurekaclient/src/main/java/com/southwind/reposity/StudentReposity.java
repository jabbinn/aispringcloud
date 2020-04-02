package com.southwind.reposity;

import com.southwind.entity.Student;

import java.util.Collection;

public interface StudentReposity {
    public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
