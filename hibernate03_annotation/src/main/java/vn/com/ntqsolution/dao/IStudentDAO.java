package vn.com.ntqsolution.dao;

import vn.com.ntqsolution.bo.Student;

import java.util.List;

public interface IStudentDAO {

    List<Student> getAll();

    Student getOneById(int id);

    boolean addNew(Student student);

    boolean update(Student student);

    boolean delete(Student student);

}
