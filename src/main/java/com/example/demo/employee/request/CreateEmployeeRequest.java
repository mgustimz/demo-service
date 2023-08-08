package com.example.demo.employee.request;

import com.example.demo.validator.ValidationAware;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigInteger;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateEmployeeRequest extends ValidationAware<CreateEmployeeRequest> {

    @NotBlank(message = "Name cannot be empty")
    String name;

    @NotNull(message = "Salary cannot be empty")
    BigInteger salary;

    Integer grade;
}
