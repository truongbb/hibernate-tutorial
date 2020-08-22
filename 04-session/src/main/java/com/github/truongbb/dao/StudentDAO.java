package com.github.truongbb.dao;

import com.github.truongbb.bo.Student;

import java.util.List;


public interface StudentDAO {

  List<Student> getAll();

  Student findById(int id);

  boolean addNew(Student student);

  boolean updateStudent(Student student);

  boolean deleteStudent(Student student);
}
