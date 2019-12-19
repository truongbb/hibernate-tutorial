package vn.com.ntqsolution.mainrun;

import vn.com.ntqsolution.dao.IStudentDAO;
import vn.com.ntqsolution.dao.StudentDAO;

public class MainRun {

    public static void main(String[] args) {

        IStudentDAO studentDAO = new StudentDAO();

        // lấy ds sinh viên
        studentDAO.getAll().forEach(System.out::println);

    }


    /**
     * ----------CÁC TRẠNG THÁI CỦA OBJECT KHI HOẠT ĐỘNG VỚI HIBERNATE-----------
     * ref: https://o7planning.org/vi/10201/huong-dan-lap-trinh-java-hibernate-cho-nguoi-moi-bat-dau
     *
     * Khi hoạt động với hibernate, chúng ta cần biết được các trạng thái của một object để quản lý và sử dụng sao cho phù hợp
     *
     * Mô tả trong ảnh để tại thư mục img
     *
     * Các trạng thái bao gồm:
     * - Transient
     * - Persitent
     * - Detached
     * - Removed
     *
     * ====TRANSIENT====
     * Trường hợp bạn tạo mới một đối tượng java từ một Entity, đối tượng đó sẽ có trạng thái là Transient.
     * Hibernate không biết về sự tồn tại của nó. Nó nằm ngoài sự quản lý của Hibernate.
     * Và tất nhiên hibernate sẽ không quản lý obj này, mà là java sẽ quản lý
     *
     *
     * ====PERSITENT====
     * Trường hợp bạn lấy ra đối tượng Entity thông qua các phương thức get, load, find, getSingleResult,..
     * bạn có được một đối tượng nó tương ứng với 1 bản ghi dưới database. Đối tượng này có trạng thái Persistent.
     * Nó được quản lý bởi Hibernate.
     * Ngoài ra, để chuyển 1 obj được tạo từ Entity từ Transient thành Persitent thì ta có thể sử dụng các hàm
     * save, saveOrUpdate, persist, merge
     *
     * ====DETACHED====
     * Là trạng thái tách ra từ Persitent, nói cách khác là thoát khỏi sự quản lý của Hibernate
     * 1 obj từ trạng thái persistent có thể sử dụng hàm evict hoặc clear để chuyển thhành trạng thái detached
     * và ngược lại, 1 obj đang ở trạng thái detached ta có thể sử dụng phương thức update, save, merge, saveOrUpdate, refresh
     * để chuyển trạng thái của nó về thành persistent do hibernate quản lý
     *
     *
     * ====REMOVE====
     * Là trạng thái bị xóa, bị loại bỏ từ trạng thái Pesistent, nghĩa là khi 1 obj đang ở persistent,
     * ta gọi hàm remove() hoặc delete() để chuyển trạng thái của nó về thành REMOVE,
     * nó bị xóa, tương đương với 1 record trong DB bị xóa
     *
     *
     */
}
