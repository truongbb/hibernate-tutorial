package vn.com.ntqsolution.bo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Student {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_STUDENT")
    @SequenceGenerator(name = "GEN_ID_STUDENT", sequenceName = "SEQ_STUDENT", allocationSize = 1)
    private Long id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "classname", nullable = false)
    private String className;


    public Student(String fullName, Date birthday, String className) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.className = className;
    }

}
