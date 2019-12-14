package vn.com.ntqsolution.mainrun;

import vn.com.ntqsolution.dao.IStudentDAO;
import vn.com.ntqsolution.dao.StudentDAO;

public class MainRun {

    public static void main(String[] args) {

        IStudentDAO studentDAO = new StudentDAO();

        // lấy ds sinh viên
        studentDAO.getAll().forEach(System.out::println);

    }
}
