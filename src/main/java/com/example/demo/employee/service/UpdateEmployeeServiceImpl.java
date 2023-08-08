package com.example.demo.employee.service;

import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.entity.Employee;
import com.example.demo.employee.presenter.UpdateEmployeePresenter;
import com.example.demo.employee.request.UpdateEmployeeRequest;
import com.example.demo.employee.response.UpdateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeServiceImpl implements UpdateEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void update(UpdateEmployeeRequest request, UpdateEmployeePresenter presenter) {
        validateRequest(request, presenter);

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();

        boolean isEmployeeExist = employeeRepository.existsById(request.getId());

        if (!isEmployeeExist) {
            presenter.present(response);
        } else {
            Employee employee = new Employee(request.getId(), request.getName(), request.getSalary(), request.getGrade());
            Employee employeeUpdated = employeeRepository.save(employee);
            response = new UpdateEmployeeResponse(employeeUpdated.getId(), employeeUpdated.getName(),
                    employeeUpdated.getSalary(), employeeUpdated.getGrade());
            presenter.present(response);
        }

    }

    private void validateRequest(UpdateEmployeeRequest request, UpdateEmployeePresenter presenter) {
        if (null == request) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        if (null == presenter) {
            throw new IllegalArgumentException("Presenter cannot be null");
        }

        request.validate();
    }
}
