package com.example.demo.employee.usecase.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record UpdateEmployeeRequest(@NotNull(message = "ID cannot be empty") Long id,
                                    @NotBlank(message = "Name cannot be empty") String name,
                                    @NotNull(message = "Salary cannot be empty") BigInteger salary,
                                    @NotNull(message = "Grade cannot be empty") Integer grade) {

}
