package com.example.demo.employee.response;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEmployeeResponse extends ServiceResponse {

    private Long id;

    private String name;

    private BigInteger salary;

    private Integer grade;
}
