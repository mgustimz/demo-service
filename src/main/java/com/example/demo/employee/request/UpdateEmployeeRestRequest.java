package com.example.demo.employee.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigInteger;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class UpdateEmployeeRestRequest {

    Long id;

    String name;

    BigInteger salary;

    Integer grade;
}
