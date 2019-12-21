package vn.com.ntqsolution.theory;

public class MergeAndUpdateMethod {

    /**
     * Sự khác nhau giữa merge với saveOrUpdate trong Hibernate
     *
     *
     * Để chuyển đổi trạng thái của 1 obj trong hibernate, lesson4 có đề cập tới các phương thức
     * save(), merge(), saveOrUpdate(), persist(), remove(), delete(), evict(), ....
     *
     * Nhưng điểm băn khoăn là có sự khác biệt gì giữa merge() và saveOrUpdate()
     *
     *
     * Khi thực saveOrUpdate() 1 object:
     * Nếu  đối tượng đã tồn tại trong session thì nó không làm gì cả
     * Nếu tồn tại 1 đối tượng khác trong cùng session mà có cùng id thì sẽ xảy ra exception
     * Nếu đối tượng tượng không có id (chưa tồn tại) thì sẽ thực hiện save()
     * Nếu đối tượng có id nhưng id đó chưa có trong database thì thực hiện save()
     * Các trường hợp còn lại thực hiện update()
     *
     *
     * Khi thực hiện merge() 1 object:
     * Nếu tồn tại 1 đối tượng khác trong session có cùng id thì nó sẽ thực hiện sao chép trạng thái của đối tượng đó (không bị exception như method saveOrUpdate())
     * Nếu không có đối tượng nào có cùng id trong session thì nó sẽ cố gắng kiểm tra trong database để lấy ra hoặc tạo 1 thể hiện persistence mới
     * Khi thực hiện merge() thì nó thực hiện trả về 1 đối tượng có trạng thái persistence, còn đối tượng ban đầu vẫn sẽ không bị quản lý bởi session.
     *
     *
     * https://stackjava.com/hibernate/su-khac-nhau-giua-merge-voi-saveorupdate-trong-hibernate.html
     *
     */

}
