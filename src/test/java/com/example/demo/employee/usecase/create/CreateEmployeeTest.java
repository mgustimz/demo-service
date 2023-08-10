package com.example.demo.employee.usecase.create;

import com.example.demo.employee.persistence.Employee;
import com.example.demo.employee.persistence.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateEmployeeTest {

    private EmployeeRepository employeeRepository;

    private CreateEmployeeUseCase useCase;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        useCase = new CreateEmployeeUseCase(employeeRepository);
    }

    @Test
    void givenNullRequest_whenCreate_shouldThrowException() {
        Exception e = assertThrows(NullPointerException.class, () -> useCase.create(null));
        assertThat(e.getMessage()).isEqualTo("Cannot invoke \"com.example.demo.employee.usecase.create.CreateEmployeeRequest.name()\" because \"request\" is null");
    }

    @Test
    void givenValidRequest_whenCreate_shouldThrowException() {
        CreateEmployeeRequest request = new CreateEmployeeRequest("Susan", BigInteger.valueOf(100L), 3);
        when(employeeRepository.save(any())).thenReturn(new Employee(1L, "Susan", BigInteger.valueOf(100L), 3));
        useCase.create(request);
        verify(employeeRepository, times(1)).save(any());
    }

}