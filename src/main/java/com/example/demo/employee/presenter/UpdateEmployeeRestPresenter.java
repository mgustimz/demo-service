package com.example.demo.employee.presenter;

import com.example.demo.employee.response.UpdateEmployeeResponse;
import com.example.demo.employee.response.UpdateEmployeeRestResponse;
import lombok.Getter;

@Getter
public class UpdateEmployeeRestPresenter implements UpdateEmployeePresenter {

    private UpdateEmployeeRestResponse restResponse;

    @Override
    public void present(UpdateEmployeeResponse response) {
        if (response.getId() == null || response.getId() == 0L) {
            restResponse = new UpdateEmployeeRestResponse(response.getId(), response.getName(),
                    response.getSalary(), response.getGrade());
            restResponse.setMessage("Employee is not found");
        } else {
            restResponse = new UpdateEmployeeRestResponse(response.getId(), response.getName(),
                    response.getSalary(), response.getGrade());
        }

    }
}
