package com.crudApp.dao;

import com.crudApp.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@Transactional
public class StudentDAOImpl implements StudentDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
//
//        Session session= sessionFactory.openSession();
//        try {
//            Transaction tx=session.beginTransaction();
//            session.save(student);
//            tx.commit();
//        }catch (Exception e){
//            System.out.println("err inside save method in impl : "+e);
//        }


    }

    @Override
    public void update(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    @Override
    public void delete(int rollNo) {
        Student student = (Student) sessionFactory.getCurrentSession().load(
                Student.class, rollNo);
        if (null != student) {
            this.sessionFactory.getCurrentSession().delete(student);
        }
    }

    @Override
    public Student getStudentByRollNo(int rollNo) {
        return (Student) sessionFactory.getCurrentSession().get(
                Student.class, rollNo);
    }

    @Override

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudentsDetail() {
        return sessionFactory.getCurrentSession().createQuery("from Student").list();
    }
}
