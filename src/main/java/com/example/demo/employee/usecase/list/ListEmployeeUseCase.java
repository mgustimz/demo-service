package com.example.demo.employee.usecase.list;

import com.example.demo.employee.persistence.Employee;
import com.example.demo.employee.persistence.EmployeeRepository;
import com.example.demo.employee.persistence.Grade;
import com.example.demo.employee.persistence.GradeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class ListEmployeeUseCase implements ListEmployee {

    private final EmployeeRepository employeeRepository;

    private final GradeRepository gradeRepository;

    @Transactional
    @Override
    public ListEmployeeResponse list() {
        var response = new ListEmployeeResponse();
        List<Employee> employeeList = employeeRepository.findAll();

        List<ListEmployeeResponse.Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            Grade grade = gradeRepository.getReferenceById(Long.valueOf(employee.getGrade()));
            BigInteger totalBonus = employee.getSalary()
                    .add(employee.getSalary()
                            .multiply(BigInteger.valueOf(grade.getBonusPercentage()))
                            .divide(BigInteger.valueOf(100L))
                    );

            ListEmployeeResponse.Employee e = ListEmployeeResponse.Employee.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .salary(employee.getSalary())
                    .gradeCode(grade.getId() + ":" + grade.getName())
                    .totalBonus(totalBonus)
                    .build();

            employees.add(e);
        }
        response.setEmployeeList(employees);

        return response;
    }
}
