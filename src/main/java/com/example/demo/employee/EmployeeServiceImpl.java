package com.example.demo.employee;

import com.example.demo.employee.presenter.CreateEmployeePresenter;
import com.example.demo.employee.request.CreateEmployeeRequest;
import com.example.demo.employee.response.CreateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void create(CreateEmployeeRequest request, CreateEmployeePresenter presenter) {
        validateRequest(request, presenter);
        Employee employee = new Employee(request.getName(), request.getSalary());

        Employee employeeSaved = employeeRepository.save(employee);
        CreateEmployeeResponse response = new CreateEmployeeResponse(employeeSaved.getId());

        presenter.present(response);
    }

    private void validateRequest(CreateEmployeeRequest request, CreateEmployeePresenter presenter) {
        if (null == request) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        if (null == presenter) {
            throw new IllegalArgumentException("Presenter cannot be null");
        }

        request.validate();
    }
}
