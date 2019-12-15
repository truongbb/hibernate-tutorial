package vn.com.ntqsolution.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import vn.com.ntqsolution.bo.Student;
import vn.com.ntqsolution.utils.HibernateUtils;


public class StudentDAO implements IStudentDAO {

    Logger logger = Logger.getLogger(StudentDAO.class);

    @Override
    public List<Student> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
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

    @Override
    public Student getOneById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery("select s from Student s where s.id = :p_id");
            query.setParameter("p_id", id);
            Student student = query.getSingleResult();
            session.getTransaction().commit();
            return student;
        } catch (Exception e) {
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean addNew(Student student) {
        Session session = HibernateUtils.getSessionFactory().openSession();
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

    @Override
    public boolean update(Student student) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.error(e);
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.error(e);
        } finally {
            session.close();
        }
        return false;
    }

}
