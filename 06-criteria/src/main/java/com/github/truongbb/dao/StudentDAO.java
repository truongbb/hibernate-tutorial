package com.github.truongbb.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import com.github.truongbb.bo.Student;
import com.github.truongbb.utils.HibernateUtil;


public class StudentDAO {

  public static Logger logger = Logger.getLogger(StudentDAO.class);

  /*
   * - Criteria là 1 class chuyên để thêm các ràng buộc cho câu sql mà không cần viết sql
   *
   * - Thực ra ta nên viết sql hơn là sử dụng các ràng buộc ntn, không rõ ràng và khó kiểm soát
   *
   */

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

  public Student getOneByNameUsingSQL(String name) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      Query query = session
        .createQuery("from Student where fullname like to_char(concat(concat('%', :p_student_name), '%'))");
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

  public Student getOneByNameUsingCriteria(String name) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      Criteria criteria = session.createCriteria(Student.class);
      criteria.add(Restrictions.like("fullname", name)); // -> có phân biệt hoa thường
      criteria.add(Restrictions.ilike("fullname", name)); // -> không phân biệt hoa thường
      Student student = (Student) criteria.uniqueResult();
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

  public static void main(String[] args) {
    new StudentDAO().getAllHQL().forEach(System.out::println);
    System.out.println("aaaaaaaaaaaaaaa");
    System.out.println(new StudentDAO().getOneByNameUsingSQL("g").toString());
  }

  /*
   * - Class Restrictions còn rất nhiều các hàm để thể hiện sự ràng buộc như between, isEmpty, isNotEmpty,
   * 		gt (greater than), lt (less than), isNull, isNotNul, ....
   * - Ngoài ra còn có thể phân trang sử dụng criteria: setMaxResult, setFirstResult
   *
   * - Nhưng như ta đã thấy, hàm createCriterira bị gạch đi, tức là không còn được hỗ trợ nữa,
   * 		và không được khuyên dùng, tốt hơn hết là ta dùng SQL với setParametters sẽ được tìm hiểu sau
   *
   * */
}
