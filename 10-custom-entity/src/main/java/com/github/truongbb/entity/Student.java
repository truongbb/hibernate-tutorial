package com.github.truongbb.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "GENDER_ID")
  Gender gender;

  @Transient
  String genderValue;

}
