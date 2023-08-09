package com.example.demo.employee.controller;

import com.example.demo.employee.usecase.list.ListEmployeeResponse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public record ListEmployeeRestResponse(List<EmployeeRestResponse> employeeRestResponseList) {

    public static ListEmployeeRestResponse valueOf(ListEmployeeResponse response) {
        List<EmployeeRestResponse> responses = new ArrayList<>();
        for (ListEmployeeResponse.Employee emp : response.getEmployeeList()) {
            ListEmployeeRestResponse.EmployeeRestResponse employeeRestResponse = new EmployeeRestResponse(emp.getId(), emp.getName(), emp.getSalary(), emp.getGradeCode(), emp.getTotalBonus());
            responses.add(employeeRestResponse);
        }
        return new ListEmployeeRestResponse(responses);
    }

    record EmployeeRestResponse(Long id, String name, BigInteger salary, String gradeCode, BigInteger totalBonus) {
    }
}
