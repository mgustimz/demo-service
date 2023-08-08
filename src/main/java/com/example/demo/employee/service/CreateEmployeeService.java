package com.example.demo.employee.service;

import com.example.demo.employee.presenter.CreateEmployeePresenter;
import com.example.demo.employee.request.CreateEmployeeRequest;

public interface CreateEmployeeService {

    void create(CreateEmployeeRequest request, CreateEmployeePresenter presenter);

}
