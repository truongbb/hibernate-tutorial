# HIBERNATE - CONNECTION POOL

`Connection pooling` là một kĩ thuật để mở, đóng, chuẩn bị kết nối. Kĩ thuật thùng kết nối này là một trong những ưu điểm của hibernate khi so sánh với JDBC

Khi ta muốn truy vấn, hay thêm, cập nhật, xóa và phải thực hiện connect tới DB,
JDBC sẽ mở kết nối, thực hiện thao tác cần thiết và đóng kết nối, cứ vậy cho những lần thực hiện sau
còn hibernate, khi có 1 yêu cầu kết nối, nó sẽ lấy các connection có sẵn đã mở từ trước và cung cấp cho yêu cầu,
và sau khi thực hiện truy vấn xong, yêu cầu lại trả lại kết nối như bt

Hãy tưởng tượng cái kết nối này như tủ lạnh
với JDBC, bạn mở ra, lấy, đóng vào, và người đứng sau xếp hàng cần đồ trong tủ và cũng làm như vậy
với Hibernate, bạn mở ra lấy đồ và không đóng, thằng sau vào cứ lấy, và cứ thế
tiết kiệm được thời gian, công sức và ít bắn ra `exception`
và nếu kết hợp với `cache` thì hibernate có ưu điểm vượt trội hơn rất nhiều

Số lượng kết nối mở sẵn do ta config, khi có yêu cầu tới mà còn connection nào đang rảnh, thì hibernate sẽ cho request đó
tới connection và thực hiện truy vấn, nếu các kết nối đã có người dùng thì phải cho request vào hàng đợi,


khi một connect đã timeout, hibernate sẽ đóng và mở lại

cấu hình trong file [`hibernate.cfg.xml`](./src/main/resources/hibernate.cfg.xml)


có 3 loại connection pool được ưa dùng: `c3p0`, `Apache DBCP`, `Proxool`

trong đó `c3p0` dễ dùng và được dùng nhiều nhất, muốn dùng phải có thư viện
