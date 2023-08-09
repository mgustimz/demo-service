package com.example.demo.employee.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
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
