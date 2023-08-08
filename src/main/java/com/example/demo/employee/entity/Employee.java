package com.example.demo.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigInteger salary;

    private Integer grade;

    public Employee(String name, BigInteger salary, Integer grade) {
        this.name = name;
        this.salary = salary;
        this.grade = grade;
    }
}
