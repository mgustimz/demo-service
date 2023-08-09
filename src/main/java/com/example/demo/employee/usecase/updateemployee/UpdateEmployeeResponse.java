package com.example.demo.employee.usecase.updateemployee;

import com.example.demo.ServiceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
