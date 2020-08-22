package com.github.truongbb.mainrun;

import com.github.truongbb.bo.Student;
import com.github.truongbb.dao.StudentDAO;
import com.github.truongbb.dao.StudentDAOImpl;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class MainRun {

  static StudentDAO studentDAO = new StudentDAOImpl();
  static Logger logger = Logger.getLogger(MainRun.class);

  public static void main(String[] args) {
    menu();
  }

  private static void menu() {
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
          getAll();
          break;
        case 2:
          viewById();
          break;
        case 3:
          addNew();
          break;
        case 4:
          updateStudent();
          break;
        case 5:
          deleteStudent();
          break;
        case 6:
          System.exit(0);
      }
    } while (true);
  }


  private static void getAll() {
    List<Student> students = studentDAO.getAll();
    if (!(students == null || students.isEmpty())) {
      System.out.println("Danh sách sinh viên: ");
      students.forEach(System.out::println);
    } else {
      System.out.println("Không có bản ghi nào trong CSDL");
    }
  }

  private static void viewById() {
    System.out.print("Nhập mã sinh viên muốn xem thông tin: ");
    int id = new Scanner(System.in).nextInt();
    Student student = studentDAO.getOneById(id);
    if (student != null) {
      System.out.println(student);
    } else {
      System.out.println("Không tìm thấy sinh viên mang mã " + id);
    }
  }

  private static void addNew() {
    System.out.println("Nhập thông tin cho sinh viên mới: ");

    System.out.print("Nhập họ và tên của sinh viên: ");
    String fullName = new Scanner(System.in).nextLine();
    System.out.print("Nhập lớp mà sinh viên đang theo học: ");
    String className = new Scanner(System.in).nextLine();
    System.out.print("Nhập ngày sinh của sinh viên (dd/MM/yyyy): ");
    String birtdayString = new Scanner(System.in).nextLine();

    Date birthday = null;
    try {
      birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birtdayString);
    } catch (ParseException e) {
      logger.error(e);
    }
    boolean addingResult = studentDAO.addNew(new Student(fullName, className, birthday));

    if (addingResult) {
      System.out.println("Thêm mới thành công!");
    } else {
      System.out.println("Thêm mới thất bại!");
    }
  }


  private static void updateStudent() {
    System.out.print("Nhập mã của sinh viên muốn sửa thông tin: ");
    int id = new Scanner(System.in).nextInt();

    Student student = studentDAO.getOneById(id);
    if (student != null) {
      System.out.print("Nhập họ và tên của sinh viên: ");
      String fullName = new Scanner(System.in).nextLine();
      System.out.print("Nhập lớp mà sinh viên đang theo học: ");
      String className = new Scanner(System.in).nextLine();
      System.out.print("Nhập ngày sinh của sinh viên (dd/MM/yyyy): ");
      String birtdayString = new Scanner(System.in).nextLine();
      java.util.Date birthday = null;
      try {
        birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birtdayString);
      } catch (ParseException e) {
        logger.error(e);
      }
      boolean updateResult = studentDAO.update(new Student(id, fullName, className, birthday));

      if (updateResult) {
        System.out.println("Cập nhật thành công!");
      } else {
        System.out.println("cập nhật thất bại!");
      }
    } else {
      System.out.println("Không tìm thấy sinh viên mang mã " + id);
    }
  }

  private static void deleteStudent() {
    System.out.print("Nhập mã sinh viên muốn xóa: ");
    int id = new Scanner(System.in).nextInt();
    Student student = studentDAO.getOneById(id);
    boolean deleteResult = studentDAO.delete(student);
    if (deleteResult) {
      System.out.println("Xóa thành công!");
    } else {
      System.out.println("Xóa thất bại!");
    }
  }

}
