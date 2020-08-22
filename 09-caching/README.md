# HIBERNATE - CACHING

`Cache` là gì chắc không cần nói nhiều, trong hibernate có 2 loại cache: `level 1` và `level 2`

`Cache level 1` là mặc định, nó là `cache của session`, gắn chặt với `session`

`First level cache` chỉ liên kết với một `session object` duy nhất, các `session object` khác của ứng dụng không thấy, không thể tác động.

Phạm vi của `first level cache` là `session`. Một khi `session` đóng thì `first level cache` cũng đóng theo.

`First level cache` là mặc định, ta không thể tắt (hủy) nó.

Khi ta thực hiện query dữ liệu lần đầu, dữ liệu được lấy ra từ database và lưu trữ vào cache
`First level cache` được liên kết với `session object` này. 
Nếu ta query cùng một object và cùng một `session` như trên thì dữ liệu trả về được lấy từ `first level cache` mà câu truy vấn với database không cần được thực thi.

Dữ liệu được lưu ở `first level cache` có thể bị xóa bằng cách gọi hàm `evict()` từ `session`. 
Sau khi gọi hàm `evict()`, ta thực hiện lại query cùng object đó thì lúc này query với database được thực thi.

Ta có thể xóa dữ liệu trong tất cả các cache của các session bằng cách gọi hàm `clear()`.


#### SECOND LEVEL CACHE

Nếu `cache level 1` ở mức `session` thì level 2 là mức `session factory`, nó bao trọn tất cả session.

Cache level 2 chỉ hoạt động khi:

- Lấy đối tượng bằng ID (tuy nhiên, nếu bạn sử dụng `SQL/HQL` thì cũng không được cho dù bạn có dùng lệnh `where id = ?`) 

- Khi các liên kết ngoại của bạn là `lazy-loaded` (hoặc `eager-loaded` với `selects` thay vì `joins`)

Có nhiều loại cache level 2, nhưng người ta thường sử dụng phổ biển là `EhCache`

Cấu hình có thể xem tại file [`ehcache.xml`](./src/main/resources/ehcache.xml) và [`hibernate.cfg`](./src/main/resources/hibernate.cfg.xml)
