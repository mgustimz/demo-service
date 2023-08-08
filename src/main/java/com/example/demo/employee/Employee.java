package com.example.demo.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigInteger salary;

    public Employee(String name, BigInteger salary) {
        this.name = name;
        this.salary = salary;
    }
}
