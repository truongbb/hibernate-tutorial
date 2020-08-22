package com.github.truongbb.dao;

import com.github.truongbb.bo.Student;

import java.util.List;

public interface StudentDAO {

  List<Student> getAll();

  Student getOneById(int id);

  boolean addNew(Student student);

  boolean update(Student student);

  boolean delete(Student student);

}
