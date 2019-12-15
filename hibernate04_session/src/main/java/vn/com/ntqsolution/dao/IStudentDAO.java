package vn.com.ntqsolution.dao;

import vn.com.ntqsolution.bo.Student;

import java.util.List;


public interface IStudentDAO {

    List<Student> getAll();

    Student findById(int id);

    boolean addNew(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(Student student);
}
