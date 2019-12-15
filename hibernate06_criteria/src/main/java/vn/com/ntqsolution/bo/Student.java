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
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "fullname", nullable = false)
    String fullName;

    @Column(name = "birthday", nullable = false)
    Date birthday;

    @Column(name = "classname", nullable = false)
    String className;

}
