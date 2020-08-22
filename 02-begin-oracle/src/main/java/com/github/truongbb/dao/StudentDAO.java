package com.github.truongbb.dao;

import com.github.truongbb.bo.Student;
import com.github.truongbb.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {

  Logger logger = Logger.getLogger(StudentDAO.class);

  public List<Student> getAll() {

    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      List<Student> students = session.createQuery("from Student").list();
      session.getTransaction().commit();
      return students;
    } catch (Exception e) {
      logger.error(e);
    } finally {
      session.close();
    }
    return null;
  }

}
