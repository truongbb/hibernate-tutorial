package vn.com.ntqsolution.bo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "classname", nullable = false)
    private String className;

}
