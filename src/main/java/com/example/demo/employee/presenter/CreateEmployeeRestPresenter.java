package com.example.demo.employee.presenter;

import com.example.demo.employee.response.CreateEmployeeResponse;
import com.example.demo.employee.response.CreateEmployeeRestResponse;
import lombok.Getter;

@Getter
public class CreateEmployeeRestPresenter implements CreateEmployeePresenter {

    private CreateEmployeeRestResponse restResponse;

    @Override
    public void present(CreateEmployeeResponse response) {
        restResponse = new CreateEmployeeRestResponse(response.getId());
    }
}
