package com.github.truongbb.dao;

import com.github.truongbb.bo.Student;
import com.github.truongbb.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;

import java.util.List;


public class StudentDAO {

  Logger logger = Logger.getLogger(StudentDAO.class);

  // - trong truy vấn SQL, có các tham số cần truyền vào, ta gọi chung nó là tham số (parameter) và ta cần set giá trị cho nó trước khi thực hiện truy vấn trả về kết quả
  // - hàm chung đó chính là setParameter, khi chỉ cụ thể nó có thể là setString, setDouble, ....
  // 		hoặc khi tham số là một danh sách (một collection), ta lại dùng setParameterList, ....
  // sau đây là các ví dụ

  @SuppressWarnings("unchecked")
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

  public Student getOneById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String sql = "from Student where id = :p_student_id";
      Query<Student> query = session.createQuery(sql);
      query.setParameter("p_student_id", Long.valueOf(id)); // set Param là cách chung nhất cho mọi kiểu dữ liệu của param
      // query.setLong("p_student_id", Long.valueOf(id));// nếu không ta dùng set Long, đúng kiểu luôn
      Student student = query.uniqueResult(); // đây là lúc thực hiện câu lệnh
      session.getTransaction().commit();
      return student;
    } catch (Exception e) {
      logger.error(e);
    } finally {
      session.close();
    }
    return null;
  }

  public List<Student> getStudentList(List<Long> idList) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String sql = "from Student where id in (:p_student_id_list)";
      Query<Student> query = session.createQuery(sql);
      query.setParameterList("p_student_id_list", idList); // set Param là cách chung nhất cho mọi kiểu dữ liệu của param
      List<Student> students = query.list(); // đây là lúc thực hiện câu lệnh
      session.getTransaction().commit();
      return students;
    } catch (Exception e) {
      logger.error(e);
    } finally {
      session.close();
    }
    return null;
  }

  public boolean addNew(Student student) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.save(student);
      session.getTransaction().commit();
      return true;
    } catch (Exception e) {
      logger.error(e);
    } finally {
      session.close();
    }
    return false;
  }

  // khi ta muốn lấy về một object student mà chỉ lấy tên của nó thôi, thì có rất nhiều cách làm
  // ví dụ như lấy cả danh sách bao gồm tên tuổi ... là một student hoàn chỉnh rồi dùng java 8 map ra
  // đó cũng là 1 cách nhưng không được ưa chuộng, nếu ta xử lý được ngay ở sql thì sẽ đỡ hơn rất nhiều việc xủ lý các tầng trên
  // vì vậy nên ta nên sử dụng sql, nhưng mà Student phải có đầy đủ id, name, ...
  // mà ta lại không muốn tạo object mới ta sử dụng addScalar của hibernate, tạo nativeSQL

  public List<Student> getStudentNameList() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();
    String sql = "select s.fullname fullName from student s";
    SQLQuery sqlQuery = session.createSQLQuery(sql);
    sqlQuery.addScalar("fullName", new StringType());
    sqlQuery.setResultTransformer(Transformers.aliasToBean(Student.class));
    return sqlQuery.list();
  }

  // đây là ví dụ lấy tên của tất cả các sinh viên, vẫn dùng bean object là Student và chỉ lấy tên các giá trị khác mang giá trị null
  // chú ý, tên của thuộc tính lấy ra phải trùng với tên thuộc tính của bean class (ví dụ trên kia là "fullName")
  // và kiểu trả về phải khớp, ví dụ trên kia là StringType cuối cùng là phải transform đúng kiểu của class trả về
  // có thể addScalar cho 1 hoặc nhiều hoặc tất cả thuộc tính của một bean class

}
