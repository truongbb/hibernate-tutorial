package vn.com.ntqsolution.run;

import org.apache.log4j.Logger;
import vn.com.ntqsolution.dao.StudentDAO;


public class MainRun {

    static Logger logger = Logger.getLogger(MainRun.class);
    static StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        studentDAO.getAll().forEach(System.out::println);
    }
}
