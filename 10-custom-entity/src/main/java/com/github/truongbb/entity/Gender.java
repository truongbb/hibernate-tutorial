package com.github.truongbb.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GENDER")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gender {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "GENDER_VALUE", nullable = false)
  String value;

}
