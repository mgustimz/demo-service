package com.example.demo.employee.usecase.update;

import jakarta.validation.constraints.NotNull;

public interface UpdateEmployee {

    UpdateEmployeeResponse update(@NotNull UpdateEmployeeRequest request);

}
