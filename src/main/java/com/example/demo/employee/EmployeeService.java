package com.example.demo.employee;

import com.example.demo.employee.presenter.CreateEmployeePresenter;
import com.example.demo.employee.request.CreateEmployeeRequest;

public interface EmployeeService {

    void create(CreateEmployeeRequest request, CreateEmployeePresenter presenter);
}
