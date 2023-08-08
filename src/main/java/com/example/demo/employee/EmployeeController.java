package com.example.demo.employee;

import com.example.demo.constant.Routes;
import com.example.demo.employee.presenter.CreateEmployeeRestPresenter;
import com.example.demo.employee.request.CreateEmployeeRequest;
import com.example.demo.employee.request.CreateEmployeeRestRequest;
import com.example.demo.employee.response.CreateEmployeeRestResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Employee", description = "Employee APIs")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(Routes.EMPLOYEE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeRestResponse create(@RequestBody CreateEmployeeRestRequest restRequest) {
        CreateEmployeeRequest itemRequest = getEmployeeRequest(restRequest);
        CreateEmployeeRestPresenter restPresenter = new CreateEmployeeRestPresenter();
        employeeService.create(itemRequest, restPresenter);

        return restPresenter.getResponse();
    }

    private CreateEmployeeRequest getEmployeeRequest(CreateEmployeeRestRequest restRequest) {
        return new CreateEmployeeRequest(restRequest.getName(), restRequest.getSalary(), restRequest.getGrade());
    }
}
