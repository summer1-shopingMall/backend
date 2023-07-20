package com.example.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true)
  private String userId;

  @NotNull
  private String userName;

  @NotNull
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @NotNull
  @Column(unique = true)
  private String email;

  @NotNull
  private String type;
  //네이버인지 구글인지 카카오인지 회원가입 타입 결정

  private long address1;

  private long address2;

  private long address3;

  @NotNull
  @Column(unique = true)
  private String phone;

}
