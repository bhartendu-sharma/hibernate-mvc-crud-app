package com.crudApp.dao;

import com.crudApp.entities.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student );
    void update(Student student);
    void delete(int rollNo);
    Student getStudentByRollNo(int rollNo);
    List<Student> getAllStudentsDetail();
}
