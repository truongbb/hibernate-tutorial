package com.github.truongbb.bo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "fullname", nullable = false)
  String fullName;

  @Column(name = "birthday", nullable = false)
  Date birthday;

  @Column(name = "classname", nullable = false)
  String className;

}
