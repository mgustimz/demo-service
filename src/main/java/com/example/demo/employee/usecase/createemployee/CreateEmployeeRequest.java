package com.example.demo.employee.usecase.createemployee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record CreateEmployeeRequest(
        @NotBlank(message = "Name cannot be empty") String name,
        @NotNull(message = "Salary cannot be empty") BigInteger salary,
        @NotNull(message = "Grade cannot be empty") Integer grade
) {

}
