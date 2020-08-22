package com.github.truongbb.bo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author truongbb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

  int id;
  String fullName;
  String className;
  Date birthday;

  public Student(String fullName, String className, Date birthday) {
    this.fullName = fullName;
    this.className = className;
    this.birthday = birthday;
  }

}
