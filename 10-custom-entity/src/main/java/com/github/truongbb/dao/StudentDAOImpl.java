package com.github.truongbb.dao;

import com.github.truongbb.dto.StudentDto;
import com.github.truongbb.entity.Student;
import com.github.truongbb.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import java.util.List;


public class StudentDAOImpl implements StudentDAO {

  @Override
  public List<Student> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      List<Student> students = session.createQuery("from Student").list();
      session.getTransaction().commit();
      return students;
    } catch (HibernateException e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return null;
  }


  @Override
  public Student findById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      Query<Student> query = session.createQuery("select s from Student s where s.id = :p_student_id");
      query.setParameter("p_student_id", id);
      Student student = query.getSingleResult();
      session.getTransaction().commit();
      return student;
    } catch (HibernateException e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return null;
  }

  @Override
  public boolean addNew(Student student) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.save(student);
      session.getTransaction().commit();
      return true;
    } catch (HibernateException e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return false;
  }

  @Override
  public boolean updateStudent(Student student) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.update(student);
      session.getTransaction().commit();
      return true;
    } catch (HibernateException e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return false;
  }

  @Override
  public boolean deleteStudent(Student student) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.delete(student);
      session.getTransaction().commit();
      return true;
    } catch (HibernateException e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return false;
  }

  @Override
  public List<StudentDto> getAllStudentDto() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String sql = "select id, fullname name, gender_value from student join gender on student.gender_id = gender.id";
      NativeQuery sqlQuery = session.createSQLQuery(sql);

      sqlQuery
        .addScalar("id", new IntegerType())
        .addScalar("name", new StringType())
        .addScalar("gender", new StringType())
        .setResultTransformer(Transformers.aliasToBean(StudentDto.class));

      return sqlQuery.list();
    } catch (HibernateException e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return null;
  }

}
