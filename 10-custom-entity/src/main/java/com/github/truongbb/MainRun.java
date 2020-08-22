package com.github.truongbb;

import com.github.truongbb.dao.StudentDAO;
import com.github.truongbb.dao.StudentDAOImpl;

public class MainRun {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAOImpl();

        // lấy ds sinh viên
        studentDAO.getAll().forEach(System.out::println);

    }
}
