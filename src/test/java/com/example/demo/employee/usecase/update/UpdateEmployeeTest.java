package com.example.demo.employee.usecase.update;

import com.example.demo.employee.persistence.Employee;
import com.example.demo.employee.persistence.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UpdateEmployeeTest {

    private EmployeeRepository employeeRepository;

    private UpdateEmployeeUseCase useCase;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        useCase = new UpdateEmployeeUseCase(employeeRepository);
    }

    @Test
    void givenNullRequest_whenUpdate_shouldThrowException() {
        Exception e = assertThrows(NullPointerException.class, () -> useCase.update(null));
        assertThat(e.getMessage()).isEqualTo("Cannot invoke \"com.example.demo.employee.usecase.update.UpdateEmployeeRequest.id()\" because \"request\" is null");
    }

    @Test
    void givenValidRequest_whenCreate_shouldCallRepository() {
        UpdateEmployeeRequest request = new UpdateEmployeeRequest(1L, "Susan", BigInteger.valueOf(100L), 3);
        Optional<Employee> employee = Optional.of(new Employee(1L, "Susan", BigInteger.valueOf(100L), 3));
        when(employeeRepository.findById(any())).thenReturn(employee);
        when(employeeRepository.save(any())).thenReturn(new Employee(1L, "Susan", BigInteger.valueOf(100L), 3));
        useCase.update(request);
        verify(employeeRepository, times(1)).save(any());
    }

}