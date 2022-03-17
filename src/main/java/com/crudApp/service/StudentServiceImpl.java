package com.crudApp.service;

import com.crudApp.dao.StudentDAO;
import com.crudApp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO dao;

    public StudentDAO getDao() {
        return dao;
    }

    public void setDao(StudentDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void save(Student student) {

        dao.save(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        dao.update(student);
    }

    @Override
    @Transactional
    public void delete(int rollNo) {
        dao.delete(rollNo);
    }

    @Override
    @Transactional
    public Student getStudentByRollNo(int rollNo) {
        return dao.getStudentByRollNo(rollNo);
    }

    @Override
    @Transactional
    public List<Student> getAllStudentsDetail() {
        return dao.getAllStudentsDetail();
    }
}
