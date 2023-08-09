package com.example.demo.employee.usecase.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEmployeeResponse {

    private Long id;

    private String name;

    private BigInteger salary;

    private Integer grade;
}
