package com.example.demo.employee.service;

import com.example.demo.employee.presenter.UpdateEmployeePresenter;
import com.example.demo.employee.request.UpdateEmployeeRequest;

public interface UpdateEmployeeService {

    void update(UpdateEmployeeRequest request, UpdateEmployeePresenter presenter);

}
