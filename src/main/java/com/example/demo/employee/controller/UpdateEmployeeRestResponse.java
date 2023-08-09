package com.example.demo.employee.controller;

import com.example.demo.employee.usecase.update.UpdateEmployeeResponse;

import java.math.BigInteger;

public record UpdateEmployeeRestResponse(Long id, String name, BigInteger salary, Integer grade) {

    public static UpdateEmployeeRestResponse valueOf(UpdateEmployeeResponse response) {
        return new UpdateEmployeeRestResponse(response.getId(), response.getName(), response.getSalary(), response.getGrade());
    }
}
