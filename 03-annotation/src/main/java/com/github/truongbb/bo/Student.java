package com.github.truongbb.bo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
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
