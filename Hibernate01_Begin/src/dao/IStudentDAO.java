package dao;

import java.util.List;
import bo.Student;

public interface IStudentDAO {

	List<Student> getAll();

	Student getOneById(int id);

	boolean addNew(Student student);

	boolean update(Student student);

	boolean delete(Student student);

}
