package vn.com.ntqsolution.theory;

public class README {

	/*
	 * -------------------CACHE IN HIBERNATE--------------------------
	 * 
	 * - Cache là gì chắc không cần nói nhiều, trong hibernate có 2 loại cache:
	 * level 1 và level 2
	 * 
	 * - Cache level 1 là mặc định, nó là cache của session, gắn chặt với session
	 * 
	 * First level cache chỉ liên kết với một session object duy nhất, các session
	 * object khác của ứng dụng không thấy, không thể tác động.
	 * 
	 * Phạm vi của First level cache là Session. Một khi session đóng thì first
	 * level cache cũng đóng theo.
	 * 
	 * First level cache là mặc định, ta không thể tắt (hủy) nó.
	 * 
	 * Khi ta thực hiện query dữ liệu lần đầu, dữ liệu được lấy ra từ database và
	 * lưu trữ vào
	 * 
	 * First level cache được liên kết với Session object này. Nếu ta query cùng một
	 * object và cùng một Session như trên thì dữ liệu trả về được lấy từ First
	 * level, mà câu truy vấn với database không cần được thực thi.
	 * 
	 * Dữ liệu được lưu ở First level cache có thể bị xóa bằng cách gọi hàm evict()
	 * từ session. Sau khi gọi hàm evict(), ta thực hiện lại query cùng object đó
	 * thì lúc này query với database được thực thi.
	 * 
	 * Ta có thể xóa dữ liệu trong tất cả các cache của các session bằng cách gọi
	 * hàm clear().
	 * 
	 * 
	 */

	/*
	 * 
	 * ----------------------CACHE LEVEL 2---------------------------
	 * 
	 * Nếu cache level 1 ở mức session thì level 2 là mức session factory, nó bao
	 * trọn tất cả session
	 * 
	 * Cache level 2 chỉ hoạt động khi: 
	 * +, Khi bạn lấy đối tượng bằng ID (tuy nhiên,
	 * nếu bạn sử dụng SQL/HQL thì cũng không được cho dù bạn có dùng lệnh where
	 * id=?) 
	 * +, Khi các liên kết ngoại của bạn là lazy-loaded (hoặc eager-loaded với
	 * selects thay vì joins)
	 * 
	 * 
	 * Có nhiều loại cache level 2, nhưng người ta thường sử dụng phổ biển là EhCache
	 * 
	 * Cấu hình có thể xem tại file config
	 * 
	 * 
	 */
}
