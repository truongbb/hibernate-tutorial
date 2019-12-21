package vn.com.ntqsolution.dao;

import vn.com.ntqsolution.dto.StudentDto;
import vn.com.ntqsolution.entity.Student;

import java.util.List;


public interface IStudentDAO {

    List<Student> getAll();

    Student findById(int id);

    boolean addNew(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(Student student);

    List<StudentDto> getAllStudentDto();
}
