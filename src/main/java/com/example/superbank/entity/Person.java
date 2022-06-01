package com.example.superbank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "Clients")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "Id",nullable = false)
    private Long id;

    @Column(name = "person_firstname",nullable = false)
    private String name;

    @Column(name = "person_lastname",nullable = false)
    private String surname;

    @Column(name = "person_age",nullable = false)
    private Integer age;

    @Column(name = "person_balance",nullable = false)
    private BigDecimal amount;
}
