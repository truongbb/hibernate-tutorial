package vn.com.ntqsolution.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import vn.com.ntqsolution.bo.Student;
import vn.com.ntqsolution.utils.HibernateUtil;

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
