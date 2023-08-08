package com.example.demo.employee.response;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = false)
@Value
public class UpdateEmployeeRestResponse extends ServiceResponse {

    Long id;

    String name;

    BigInteger salary;

    Integer grade;
}
