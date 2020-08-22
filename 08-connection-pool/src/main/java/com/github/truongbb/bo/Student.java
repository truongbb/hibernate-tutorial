package com.github.truongbb.bo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
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

}
