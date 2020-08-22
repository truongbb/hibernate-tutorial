package com.github.truongbb.mainrun;

import com.github.truongbb.dao.StudentDAO;
import com.github.truongbb.dao.StudentDAOImpl;

public class MainRun {

  public static void main(String[] args) {
    StudentDAO studentDAO = new StudentDAOImpl();
    studentDAO.getAll().forEach(System.out::println);
  }

}
