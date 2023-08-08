package com.example.demo.employee.presenter;

import com.example.demo.employee.response.CreateEmployeeResponse;
import com.example.demo.employee.response.CreateEmployeeRestResponse;

public class CreateEmployeeRestPresenter implements CreateEmployeePresenter {

    private CreateEmployeeRestResponse restResponse;

    public CreateEmployeeRestResponse getResponse() {
        return restResponse;
    }

    @Override
    public void present(CreateEmployeeResponse response) {
        restResponse = new CreateEmployeeRestResponse(response.getId());
    }
}
