package com.github.truongbb.run;

import com.github.truongbb.dao.StudentDAO;
import org.apache.log4j.Logger;

public class MainRun {

  static Logger logger = Logger.getLogger(MainRun.class);
  static StudentDAO studentDAO = new StudentDAO();

  public static void main(String[] args) {
    studentDAO.getAll().forEach(System.out::println);
  }

}
