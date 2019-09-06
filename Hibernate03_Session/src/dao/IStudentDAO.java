package dao;

import java.util.List;

import bo.Student;

public interface IStudentDAO {

	List<Student> getAll();

	Student findById(int id);

	boolean addNew(Student student);

	boolean updateStudent(Student student);

	boolean deleteStudent(Student student);
}
