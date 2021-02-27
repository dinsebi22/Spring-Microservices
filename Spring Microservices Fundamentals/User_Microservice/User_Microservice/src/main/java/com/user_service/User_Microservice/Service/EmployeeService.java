package com.user_service.User_Microservice.Service;

import com.user_service.User_Microservice.Models.EmployeeModel;
import com.user_service.User_Microservice.ResponseTemplates.ResponseTemplateValueObj;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeModel> findAll();

    EmployeeModel save(EmployeeModel employeeModel);

    Optional<EmployeeModel> findById(Long id);

    void deleteById(Long id);

    ResponseTemplateValueObj getEmployeeWithDepartment(Long employeeId);

    List<EmployeeModel> findEmployeesForDepartment(Long departmentId);
}
