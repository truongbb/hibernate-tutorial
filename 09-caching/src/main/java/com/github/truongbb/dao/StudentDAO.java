package com.github.truongbb.dao;

import com.github.truongbb.bo.Student;
import com.github.truongbb.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import java.util.List;

public class StudentDAO {

  public List<Student> getListByName(String name) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    StringBuilder sql = new StringBuilder("");
    sql.append("select s.fullname from student s where s.fullname like '%' || :p_student_name || '%'");
    Query sqlQuery = session.createSQLQuery(sql.toString())
      .addScalar("fullName")
      .setResultTransformer(Transformers.aliasToBean(Student.class));
    sqlQuery.setParameter("p_student_name", name);
    return sqlQuery.list();

  }

  public List<Student> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    StringBuilder sql = new StringBuilder("");
    sql.append("select * from student");
    Query query = session.createSQLQuery(sql.toString())
      .addScalar("id", new LongType())
      .addScalar("fullName", new StringType())
      .addScalar("birthday", new DateType())
      .addScalar("className", new StringType())
      .setResultTransformer(Transformers.aliasToBean(Student.class));
    return query.list();
  }

}
