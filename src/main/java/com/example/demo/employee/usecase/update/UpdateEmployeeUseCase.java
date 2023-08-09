package com.example.demo.employee.usecase.update;

import com.example.demo.employee.persistence.Employee;
import com.example.demo.employee.persistence.EmployeeRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
class UpdateEmployeeUseCase implements UpdateEmployee {

    private final EmployeeRepository employeeRepository;

    @Override
    public UpdateEmployeeResponse update(@NotNull UpdateEmployeeRequest request) {
        Optional<Employee> employee = employeeRepository.findById(request.id());

        if (employee.isPresent()) {
            return doUpdate(request);
        }
        return new UpdateEmployeeResponse();
    }

    private UpdateEmployeeResponse doUpdate(UpdateEmployeeRequest request) {
        Employee emp = new Employee(request.id(), request.name(), request.salary(),
                request.grade());
        Employee employeeUpdated = employeeRepository.save(emp);
        return new UpdateEmployeeResponse(
                employeeUpdated.getId(),
                employeeUpdated.getName(),
                employeeUpdated.getSalary(),
                employeeUpdated.getGrade()
        );
    }
}
