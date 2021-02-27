package com.user_service.User_Microservice.Service.Service_Impl;

import com.user_service.User_Microservice.Models.EmployeeModel;
import com.user_service.User_Microservice.Repository.EmployeeRepository;
import com.user_service.User_Microservice.ResponseTemplates.ResponseTemplateValueObj;
import com.user_service.User_Microservice.Service.EmployeeService;
import com.user_service.User_Microservice.ValueObjects.DepartmentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService_Impl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;      // <---- Imp for communication between our microservices

    @Autowired
    public EmployeeService_Impl(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
        log.info("Generated Employee Service");
    }

    @Override
    public List<EmployeeModel> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public EmployeeModel save(EmployeeModel employeeModel) {
        return this.employeeRepository.save(employeeModel);
    }

    @Override
    public Optional<EmployeeModel> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public ResponseTemplateValueObj getEmployeeWithDepartment(Long employeeId){
        ResponseTemplateValueObj responseTemplateValueObj = new ResponseTemplateValueObj();

        EmployeeModel employeeModel = employeeRepository.findById(employeeId).get();
        log.info(employeeModel+"");
        DepartmentModel departmentModel = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departmentService/getDepartment/" + employeeModel.getDepartmentId(),
                DepartmentModel.class );

        // This is the same thing as Above the only diference is that instead of using localhost:9001
        // we use the application name defined in the application.yml file of the Department Service
        //  DepartmentModel departmentModel = restTemplate.getForObject("http://localhost:9001/departmentService/getDepartment/" + employeeModel.getDepartmentId(),


                responseTemplateValueObj.setEmployeeModel(employeeModel);
        responseTemplateValueObj.setDepartmentModel(departmentModel);

        return responseTemplateValueObj;
    }

    @Override
    public List<EmployeeModel> findEmployeesForDepartment(Long departmentId){
        return this.employeeRepository.findEmployeesForDepartment(departmentId);
    }
}
