package com.example.shoppingmall.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userNid;
    //회원가입시 생성되는 고유넘버

    @NotNull
    private String zipCode;

    @NotNull
    private String address;

    private String addressDetail;

}
