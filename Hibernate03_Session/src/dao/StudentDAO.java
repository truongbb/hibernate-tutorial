package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import bo.Student;
import utils.HibernateUtil;

@SuppressWarnings("unchecked")
public class StudentDAO implements IStudentDAO {

	/*
	 * 
	 * - Session trong hibernate được sử dụng để kết nối tới cơ sở dữ liệu trong một
	 * phiên làm việc nhất định - Session không nên mở trong 1 thời gian dài vì nó
	 * không an toàn, nó nên được mở ra và đóng vào sau khi sử dụng - Session cung
	 * cấp các phương thức để select, thêm sửa xóa đối tượng - Một đối tượng được
	 * hibernate xem xét là tồn tại dưới 1 trong 3 dạng sau +, transient: chỉ là
	 * object java bình thường, chưa được hibernate quản lý và dĩ nhiên khong thao
	 * tác bằng session được +, persistent: đối tượng được hibernate quản lý, class
	 * trong java đại diện cho 1 bảng của db (vd: class Student) ta sử dụng được
	 * session để thao tác với object này như lưu vào db, sửa, xóa từ db, .. +,
	 * detached: đối tượng từ persistent trở thành do đóng session, đối tượng này sẽ
	 * được hibernate xóa đi - Nên sử dụng transaction để tránh các trường hợp mất
	 * mát dữ liệu không mong muốn
	 */

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

}
