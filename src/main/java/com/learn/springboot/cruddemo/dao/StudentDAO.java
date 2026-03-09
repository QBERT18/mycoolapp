package com.learn.springboot.cruddemo.dao;

import com.learn.springboot.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student newStudent);

    Student findById(int id);
}
