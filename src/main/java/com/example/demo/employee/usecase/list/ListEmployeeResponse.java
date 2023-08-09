package com.example.demo.employee.usecase.list;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListEmployeeResponse {

    private List<Employee> employeeList;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Employee {

        private Long id;

        private String name;

        private BigInteger salary;

        private String gradeCode;

        private BigInteger totalBonus;
    }
}
