package mainrun;

import dao.IStudentDAO;
import dao.StudentDAO;

public class MainRun {

	public static void main(String[] args) {

		IStudentDAO studentDAO = new StudentDAO();

		// lấy ds sinh viên
		studentDAO.getAll().forEach(System.out::println);

	}
}
