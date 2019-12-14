package vn.com.ntqsolution.run;

import java.util.Arrays;

import org.apache.log4j.Logger;
import vn.com.ntqsolution.bo.Student;
import vn.com.ntqsolution.dao.StudentDAO;


public class MainRun {

    static Logger logger = Logger.getLogger(MainRun.class);
    static StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        studentDAO.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println(studentDAO.getOneById(5));

        // studentDAO.addNew(new Student("Bùi Bá Trường", new java.util.Date(), "CNPM1"));
        System.out.println("-----------------------------");
        studentDAO.getStudentList(Arrays.asList(1L, 10L, 5L, 8L)).forEach(System.out::println);
        System.out.println("-----------------------------");

        studentDAO.getStudentNameList().forEach(System.out::println);
        studentDAO.getStudentNameList().stream().map(Student::getFullName).filter(t -> t.contains("n")).forEach(System.out::println);

    }
}
