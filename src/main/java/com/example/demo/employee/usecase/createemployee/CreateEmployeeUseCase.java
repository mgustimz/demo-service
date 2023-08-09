package com.example.demo.employee.usecase.createemployee;

import com.example.demo.employee.persistence.Employee;
import com.example.demo.employee.persistence.EmployeeRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
class CreateEmployeeUseCase implements CreateEmployee {

    private final EmployeeRepository employeeRepository;

    @Override
    public CreateEmployeeResponse create(@NotNull CreateEmployeeRequest request) {
        Employee employee = new Employee(request.name(), request.salary(), request.grade());

        Employee employeeSaved = employeeRepository.save(employee);

        return new CreateEmployeeResponse(employeeSaved.getId());
    }
}
