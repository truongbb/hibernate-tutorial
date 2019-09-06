package mainrun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bo.Student;
import dao.IStudentDAO;
import dao.StudentDAO;

public class MainRun {

	static IStudentDAO studentDAO = new StudentDAO();
	static Logger logger = Logger.getLogger(MainRun.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		do {
			System.out.println("PHẦN MỀM QUẢN LÝ SINH VIÊN\n");
			System.out.println("1. Hiển thị danh sách sinh viên.");
			System.out.println("2. Hiển thị thông tin một sinh viên.");
			System.out.println("3. Thêm mới một sinh viên.");
			System.out.println("4. Sửa thông tin một sinh viên.");
			System.out.println("5. Xóa tin một sinh viên.");
			System.out.println("6. Thoát.");
			System.out.println("---------------------------------");
			System.out.print("Xin mời chọn chức năng: ");
			int choice = 0;
			do {
				int temp = new Scanner(System.in).nextInt();
				if (temp > 0 && temp < 7) {
					choice = temp;
					break;
				}
				System.out.print("Chức năng vừa chọn không tồn tại, yêu cầu nhập lại: ");
			} while (true);
			switch (choice) {
			case 1:
				List<Student> students = studentDAO.getAll();
				if (students != null && !students.isEmpty()) {
					System.out.println("Danh sách sinh viên: ");
					students.forEach(t -> {
						System.out.println(t.toString());
					});
				} else {
					System.out.println("Không có bản ghi nào trong CSDL");
				}
				break;
			case 2:
				System.out.println("Nhập mã sinh viên muốn xem thông tin: ");
				int id2 = new Scanner(System.in).nextInt();
				Student student = studentDAO.getOneById(id2);
				if (student != null) {
					System.out.println(student.toString());
				} else {
					System.out.println("Không tìm thấy sinh viên mang mã " + id2);
				}
				break;
			case 3:
				System.out.println("Nhập thông tin cho sinh viên mới: ");
				System.out.println("Nhập họ và tên của sinh viên: ");
				String fullName3 = new Scanner(System.in).nextLine();
				System.out.println("Nhập lớp mà sinh viên đang theo học: ");
				String className3 = new Scanner(System.in).nextLine();
				System.out.println("Nhập ngày sinh của sinh viên (dd/MM/yyyy): ");
				String birtdayString3 = new Scanner(System.in).nextLine();
				java.util.Date birthday3 = null;
				try {
					birthday3 = new SimpleDateFormat("dd/MM/yyyy").parse(birtdayString3);
				} catch (ParseException e) {
					// e.printStackTrace();
					logger.error(e);
				}
				boolean addingResult = studentDAO.addNew(new Student(fullName3, className3, birthday3));
				if (addingResult) {
					System.out.println("Thêm mới thành công!");
				} else {
					System.out.println("Thêm mới thất bại!");
				}
				break;
			case 4:
				System.out.println("Nhập mã của sinh viên muốn sửa thông tin: ");
				int id4 = new Scanner(System.in).nextInt();
				Student student4 = studentDAO.getOneById(id4);
				if (student4 != null) {
					System.out.println("Nhập họ và tên của sinh viên: ");
					String fullName4 = new Scanner(System.in).nextLine();
					System.out.println("Nhập lớp mà sinh viên đang theo học: ");
					String className4 = new Scanner(System.in).nextLine();
					System.out.println("Nhập ngày sinh của sinh viên (dd/MM/yyyy): ");
					String birtdayString4 = new Scanner(System.in).nextLine();
					java.util.Date birthday4 = null;
					try {
						birthday4 = new SimpleDateFormat("dd/MM/yyyy").parse(birtdayString4);
					} catch (ParseException e) {
						// e.printStackTrace();
						logger.error(e);
					}
					boolean updateResult = studentDAO.update(new Student(id4, fullName4, className4, birthday4));
					if (updateResult) {
						System.out.println("Cập nhật thành công!");
					} else {
						System.out.println("cập nhật thất bại!");
					}
				} else {
					System.out.println("Không tìm thấy sinh viên mang mã " + id4);
				}

				break;
			case 5:
				System.out.println("Nhập mã sinh viên muốn xóa: ");
				int id5 = new Scanner(System.in).nextInt();
				Student student5 = studentDAO.getOneById(id5);
				boolean deleteResult = studentDAO.delete(student5);
				if (deleteResult) {
					System.out.println("Xóa thành công!");
				} else {
					System.out.println("Xóa thất bại!");
				}
				break;
			case 6:
				System.exit(0);
			}
		} while (true);
	}

}
