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
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "fullName", nullable = false)
    String fullName;

    @Column(name = "className", nullable = false)
    String className;

    @Column(name = "birthday", nullable = false)
    Date birthday;

    public Student(String fullName, String className, Date birthday) {
        this.fullName = fullName;
        this.className = className;
        this.birthday = birthday;
    }

}
