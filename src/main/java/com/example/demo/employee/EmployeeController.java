package com.example.demo.employee;

import com.example.demo.constant.Routes;
import com.example.demo.employee.presenter.CreateEmployeeRestPresenter;
import com.example.demo.employee.presenter.UpdateEmployeeRestPresenter;
import com.example.demo.employee.request.CreateEmployeeRequest;
import com.example.demo.employee.request.CreateEmployeeRestRequest;
import com.example.demo.employee.request.UpdateEmployeeRequest;
import com.example.demo.employee.request.UpdateEmployeeRestRequest;
import com.example.demo.employee.response.CreateEmployeeRestResponse;
import com.example.demo.employee.response.UpdateEmployeeRestResponse;
import com.example.demo.employee.service.CreateEmployeeService;
import com.example.demo.employee.service.UpdateEmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employee", description = "Employee APIs")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final CreateEmployeeService createEmployeeService;

    private final UpdateEmployeeService updateEmployeeService;

    @PostMapping(Routes.EMPLOYEE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeRestResponse create(@RequestBody CreateEmployeeRestRequest restRequest) {
        CreateEmployeeRequest itemRequest = getEmployeeRequest(restRequest);
        CreateEmployeeRestPresenter restPresenter = new CreateEmployeeRestPresenter();
        createEmployeeService.create(itemRequest, restPresenter);

        return restPresenter.getRestResponse();
    }

    @PutMapping(path = Routes.EMPLOYEE)
    @ResponseStatus(HttpStatus.OK)
    public UpdateEmployeeRestResponse update(@RequestBody UpdateEmployeeRestRequest restRequest) {
        UpdateEmployeeRequest employeeRequest = getEmployeeRequest(restRequest);
        UpdateEmployeeRestPresenter restPresenter = new UpdateEmployeeRestPresenter();
        updateEmployeeService.update(employeeRequest, restPresenter);

        return restPresenter.getRestResponse();
    }

    private CreateEmployeeRequest getEmployeeRequest(CreateEmployeeRestRequest restRequest) {
        return new CreateEmployeeRequest(restRequest.getName(), restRequest.getSalary(), restRequest.getGrade());
    }

    private UpdateEmployeeRequest getEmployeeRequest(UpdateEmployeeRestRequest restRequest) {
        return new UpdateEmployeeRequest(restRequest.getId(), restRequest.getName(), restRequest.getSalary(), restRequest.getGrade());
    }
}
