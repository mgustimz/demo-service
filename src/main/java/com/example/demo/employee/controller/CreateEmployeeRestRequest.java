package com.example.demo.employee.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigInteger;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class CreateEmployeeRestRequest {

    String name;

    BigInteger salary;

    Integer grade;
}
