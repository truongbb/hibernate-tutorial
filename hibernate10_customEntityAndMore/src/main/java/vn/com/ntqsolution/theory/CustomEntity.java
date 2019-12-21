package vn.com.ntqsolution.theory;

public class CustomEntity {

    /**
     * CUSTOM ENTITY
     *
     * Entity trong hibernate được cấu hình không chỉ chứa các đinh nghĩa cho ID và các cột, mà hơn thế nữa, nó còn miêu tả quan hệ và các thuộc tính không thuộc bảng
     *
     *
     * =====MÔ TẢ QUAN HỆ=====
     *
     * Rất đơn giản, trong SQL có các quan hệ giữa các bảng thế nào thì ngay trong Entity của Hibernate sẽ mô tả như thế
     * - Quan hệ 1-1: @OneToOne
     * - Quan hệ 1-N: @OneToMany hoặc @ManyToOne
     * - Quan hệ N-N: @ManyToMany
     *
     * Mỗi annotation này mô tả cách mà cách bảng liên kết với nhau, và tựu chung lại chúng có những config sau:
     * - fetch: là cách mà khi truy vấn tới Entity này (sử dụng bảng này) thì hibernate sẽ truy vấn ra sao.
     *   Có 2 loại FetchType đó chính là LAZY và EAGER
     *      +, fetch = FetchType.LAZY tức là khi bạn find, select đối tượng STUDENT từ database
     *          thì nó sẽ không lấy các đối tượng GENDER liên quan
     *      +, fetch = FetchType.EAGER tức là khi bạn find, select đối tượng STUDENT từ database
     *          thì tất cả các đối tượng GENDER liên quan sẽ được lấy ra và lưu vào gender
     *
     * Chú ý rằng:
     * fetch = FetchType.LAZY tức là mặc định không lấy ra các đối tượng liên quan nhưng bên trong transaction,
     *      bạn gọi method student.getGender() thì nó vẫn có dữ liệu nhé,
     *      bởi vì khi bạn gọi method nó sẽ query các đối tượng GENDER liên quan và lưu vào gender,
     *      và khi kết thúc transaction gender sẽ chứa các giới tính liên quan.
     *      Tuy nhiên nếu bạn không gọi method đó thì gender không có dữ liệu
     *      và khi kết thúc transaction gender sẽ không có đối tượng student nào
     * fetch = FetchType.EAGER thì khi lấy đối tượng STUDENT là nó mặc định query luôn đối tượng GENDER liên quan
     *      và lưu vào gender, do đó khi kết thúc transaction, gender sẽ có chứa các đối tượng GENDER của STUDENT đó.
     *
     *
     * Với annotation @ManyToOne và @OneToOne thì fetchType mặc định là EAGER
     * Với annotation @ManyToMany và @OneToMany thì fetchType mặc định là LAZY
     * Có sự khác nhau như trên là vì với annotation @ManyToOne, và @OneToOne thì khi select với fetchType = EAGER
     * nó chỉ lấy ra nhiều nhất 1 đối tượng liên quan nên không ảnh hưởng gì tới performance.
     * Còn nếu sử dụng fetchType = EAGER với @ManyToMany, @OneToMany thì có thể nó lấy ra rất nhiều đối tượng liên quan
     * dẫn tới làm giảm hiệu năng, tốn bộ nhớ.
     *
     * https://stackjava.com/hibernate/hibernate-fetchtype-la-gi-phan-biet-fetchtype-lazy-voi-eager.html
     *
     *
     * - Ngoài ra, có các annotation để hỗ trợ làm rõ annotation quan hệ trên đó chính là @JoinColumn và @JoinTable
     *
     * Đơn giản là ta chỉ cần chỉ ra tên của cột hoặc bảng mà từ bảng đó muốn join sang mà thôi
     * JoinColumn được ví dụ ngay trong Student
     * Còn JoinTable sẽ phải chỉ rõ hơn như sau
     * @ManyToMany
     * @JoinTable(
     *      name = "USER_ROLE",
     *      joinColumns = @JoinColumn(name = "USER_ID"),
     *      inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
     *  )
     *  Set<RoleEntity> roleEntities;
     *
     * =============================================================
     *
     * ====CÁC THUỘC TÍNH KHÔNG THUỘC BẢNG=====
     *  Khi mà ta muốn sử dụng 1 class để hứng data từ DB, kết quả của câu truy vấn khi join nhiều bảng với nhau
     *  Thì việc sử dụng entity với các annotation được đề cập bên trên là hoàn toàn có thể.
     *
     *  Nhưng nếu bài toán bây giờ khác đi một chút, chúng ta có một nghiệp vụ rất khó và loằng ngoằng,
     *  phải tự viết sql và không thể sử dụng Entity để mapping được nữa, bắt buộc map từng trường một bằng tay
     *  và các trường hoàn toàn lẻ tẻ lấy từ các Entity khác nhau chứ không hề lấy nguyên vẹn tất cả các thuộc tính của một entity nào cả
     *  thì lúc ấy sẽ có 2 cách:
     *
     * - Sử dụng DTO:
     *  Chúng ta có thể sử dụng DTO (data transfer object) theo đúng nghĩa của nó - obj mang dữ liệu
     *  Trong DTO chúng ta có thể định nghĩa các thuộc tính mà ta muốn như bình thường, thêm, bớt, gộp thuộc tính từ các bảng
     *  Để chúng ta sử dụng nó cho một câu query nào đó rất phức tạp và trả ra nhiều trường mà Entity khó lòng xử lý gọn bằng
     *  (demo ở package dto và dao)
     *
     * - Sủ dụng chính Entity:
     *
     * Nếu vẫn cố chấp hỏi rằng có cách nào vẫn sử dụng entity để giải quyết vấn đề này không thì câu trả lời vẫn là có.
     *
     * Nhưng mà nếu thêm trường chúng ta cần vào entity mà trường đó không thuộc bảng trong DB thì hibernate sẽ báo lỗi.
     * Tất nhiên là thế, vì vậy chúng ta cần dùng thêm annotation @Transient
     * Annotation này sẽ đánh dấu là trường đó chỉ ở java thôi, không có trong DB, nhưng chúng ta vẫn có thể query và lưu dữ liệu vào đó như bình thường
     * Một cách rất hay phải không, nhưng cách này không nên làm cho lắm
     * Vì chính cách làm naỳ đang làm "bẩn" các Entity đi, hãy để entity lưu giữ đúng và chính xác những gì chúng có ở DB thôi.
     * Muốn thêm bớt trường để custom sử dụng thì hãy tạo ra DTO, đó là một cách hay và hợp lý hơn.
     *
     * ==============================================
     *
     * Ngoài ra còn có rất nhiều annotation để miêu tả một entity cụ thể và rõ ràng mà hibernate cung cấp
     *
     * https://dzone.com/articles/all-hibernate-annotations-mapping-annotations
     *
     * https://howtodoinjava.com/hibernate/hibernate-jpa-2-persistence-annotations-tutorial/
     *
     * https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.html
     */

}
