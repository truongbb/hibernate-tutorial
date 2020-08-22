package com.github.truongbb.dao;

import com.github.truongbb.bo.Student;
import com.github.truongbb.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {

  public static Logger logger = Logger.getLogger(StudentDAO.class);
  // có 2 cách để thực hiện câu lệnh sql với hibernate, đó là HQL và native SQL

  // HQL là hibernate quey language do hibernate viết dựa trên cú pháp của SQL
  // HQL sẽ được dịch sang SQL và chạy như bình thường
  // khuyến nghị nên dùng HQL, vì nó hỗ trợ rất nhiều các hàm như save, update, saveOrUpdate, delete, ....
  public List<Student> getAllHQL() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String hql = "from Student";
      Query<Student> query = session.createQuery(hql);
      List<Student> students = query.list();
      session.getTransaction().commit();
      return students;
    } catch (Exception e) {
      session.getTransaction().rollback();
      e.printStackTrace();
      logger.error(e);
    } finally {
      session.close();
    }
    return null;
  }

  public Student getOneByName(String name) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      Query query = session.createQuery(
        "from Student where fullname like to_char(concat(concat('%', :p_student_name), '%'))");
      query.setParameter("p_student_name", name);
      Student student = (Student) query.uniqueResult();
      session.getTransaction().commit();
      return student;
    } catch (HibernateException e) {
      session.getTransaction().rollback();
      logger.error(e);
    } finally {
      session.close();
    }
    return null;
  }

  public List<Student> getAllSQL() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String sql = "select s.* from Student s";
      SQLQuery query = session.createSQLQuery(sql);
      query.addEntity(Student.class);
      List<Student> students = query.list();
      session.getTransaction().commit();
      return students;
    } catch (Exception e) {
      session.getTransaction().rollback();
      logger.error(e);
    } finally {
      session.close();
    }
    return null;
  }

  public static void main(String[] args) {
    new StudentDAO().getAllHQL().forEach(System.out::println);
    System.out.println("aaaaaaaaaaaaaaa");
    System.out.println(new StudentDAO().getOneByName("g"));
  }
}
