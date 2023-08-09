package com.example.demo.employee.usecase.create;

import jakarta.validation.constraints.NotNull;

public interface CreateEmployee {

    CreateEmployeeResponse create(@NotNull CreateEmployeeRequest request);

}
