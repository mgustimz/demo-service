package com.example.demo.employee.controller;

import com.example.demo.constant.Routes;
import com.example.demo.employee.usecase.createemployee.CreateEmployee;
import com.example.demo.employee.usecase.createemployee.CreateEmployeeRequest;
import com.example.demo.employee.usecase.updateemployee.UpdateEmployee;
import com.example.demo.employee.usecase.updateemployee.UpdateEmployeeRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employee", description = "Employee APIs")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final CreateEmployee createEmployee;

    private final UpdateEmployee updateEmployee;

    @PostMapping(Routes.EMPLOYEE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeRestResponse create(@RequestBody CreateEmployeeRestRequest restRequest) {
        var itemRequest = new CreateEmployeeRequest(
                restRequest.getName(),
                restRequest.getSalary(),
                restRequest.getGrade()
        );
        var response = createEmployee.create(itemRequest);

        return CreateEmployeeRestResponse.valueOf(response);
    }

    @PutMapping(path = Routes.EMPLOYEE)
    @ResponseStatus(HttpStatus.OK)
    public UpdateEmployeeRestResponse update(@RequestBody UpdateEmployeeRestRequest restRequest) {
        var employeeRequest = new UpdateEmployeeRequest(
                restRequest.getId(),
                restRequest.getName(),
                restRequest.getSalary(),
                restRequest.getGrade()
        );
        var response = updateEmployee.update(employeeRequest);

        return UpdateEmployeeRestResponse.valueOf(response);
    }
}
