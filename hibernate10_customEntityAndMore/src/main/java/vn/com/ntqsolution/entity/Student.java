package vn.com.ntqsolution.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "fullname", nullable = false)
    String fullName;

    @Column(name = "birthday", nullable = false)
    Date birthday;

    @Column(name = "classname", nullable = false)
    String className;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "GENDER_ID", cascade = CascadeType.REMOVE)
    Gender gender;

    @Transient
    String genderValue;

}
