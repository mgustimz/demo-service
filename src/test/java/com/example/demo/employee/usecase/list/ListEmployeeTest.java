package com.example.demo.employee.usecase.list;

import com.example.demo.employee.persistence.Employee;
import com.example.demo.employee.persistence.EmployeeRepository;
import com.example.demo.employee.persistence.Grade;
import com.example.demo.employee.persistence.GradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ListEmployeeTest {

    private EmployeeRepository employeeRepository;

    private GradeRepository gradeRepository;

    private ListEmployeeUseCase useCase;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        gradeRepository = mock(GradeRepository.class);
        useCase = new ListEmployeeUseCase(employeeRepository, gradeRepository);
    }

    @Test
    void givenValidRequest_whenGetList_shouldCallRepository() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("Susan", BigInteger.valueOf(3980000L), 3);
        employees.add(employee);

        when(employeeRepository.findAll()).thenReturn(employees);
        when(gradeRepository.getReferenceById(any())).thenReturn(new Grade(3L, "Staff", 3));
        useCase.list();

        verify(employeeRepository, times(1)).findAll();
        verify(gradeRepository, times(1)).getReferenceById(any());
    }

}