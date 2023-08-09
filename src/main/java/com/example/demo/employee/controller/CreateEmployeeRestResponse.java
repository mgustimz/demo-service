package com.example.demo.employee.controller;

import com.example.demo.employee.usecase.create.CreateEmployeeResponse;

public record CreateEmployeeRestResponse(Long id) {

    public static CreateEmployeeRestResponse valueOf(CreateEmployeeResponse response) {
        return new CreateEmployeeRestResponse(response.getId());
    }
}
