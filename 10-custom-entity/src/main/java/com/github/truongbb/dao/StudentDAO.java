package com.github.truongbb.dao;

import com.github.truongbb.dto.StudentDto;
import com.github.truongbb.entity.Student;

import java.util.List;


public interface StudentDAO {

  List<Student> getAll();

  Student findById(int id);

  boolean addNew(Student student);

  boolean updateStudent(Student student);

  boolean deleteStudent(Student student);

  List<StudentDto> getAllStudentDto();
}
