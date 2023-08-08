package com.example.demo.employee.request;

import com.example.demo.validator.ValidationAware;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigInteger;

@Value
@EqualsAndHashCode(callSuper = false)
public class UpdateEmployeeRequest extends ValidationAware<UpdateEmployeeRequest> {

    @NotNull(message = "ID cannot be empty")
    Long id;

    @NotBlank(message = "Name cannot be empty")
    String name;

    @NotNull(message = "Salary cannot be empty")
    BigInteger salary;

    @NotNull(message = "Grade cannot be empty")
    Integer grade;
}
