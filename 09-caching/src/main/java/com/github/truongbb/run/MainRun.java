package com.github.truongbb.run;

import com.github.truongbb.bo.Student;
import com.github.truongbb.dao.StudentDAO;
import org.apache.log4j.Logger;


public class MainRun {

  static Logger logger = Logger.getLogger(MainRun.class);
  static StudentDAO studentDAO = new StudentDAO();

  public static void main(String[] args) {

    studentDAO.getListByName("n").stream()
      .map(Student::getFullName)
      .filter(t -> t.contains("n"))
      .forEach(System.out::println);

    System.out.println("--------------------------------");
    studentDAO.getAll().forEach(System.out::println);
  }

}
