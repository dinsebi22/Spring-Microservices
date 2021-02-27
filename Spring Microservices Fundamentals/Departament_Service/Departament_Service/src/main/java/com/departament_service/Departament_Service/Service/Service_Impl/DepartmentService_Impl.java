package com.departament_service.Departament_Service.Service.Service_Impl;

import com.departament_service.Departament_Service.Models.DepartmentModel;
import com.departament_service.Departament_Service.Repository.DepartmentRepository;
import com.departament_service.Departament_Service.ResponseTemplate.ResponseTemplateValueObj;
import com.departament_service.Departament_Service.Service.DepartmentService;
import com.departament_service.Departament_Service.ValueObjects.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService_Impl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private RestTemplate restTemplate;

    @Autowired
    public DepartmentService_Impl(DepartmentRepository departmentRepository, RestTemplate restTemplate) {
        this.departmentRepository = departmentRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<DepartmentModel> findAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public DepartmentModel save(DepartmentModel departmentModel) {
        return this.departmentRepository.save(departmentModel);
    }

    @Override
    public Optional<DepartmentModel> findById(Long id) {
        return this.departmentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    public ResponseTemplateValueObj findEmployeesForDepartment(Long id) {
        ResponseTemplateValueObj responseTemplateValueObj = new ResponseTemplateValueObj();
        DepartmentModel departmentModel = this.departmentRepository.findById(id).get();

        ResponseEntity<EmployeeModel[]> responseEntity = restTemplate
                .getForEntity("http://EMPLOYEE-SERVICE/employeeService/findEmployeesForDepartment/" + departmentModel.getId(), EmployeeModel[].class);

        responseTemplateValueObj.setDepartmentModel(departmentModel);
        responseTemplateValueObj.setEmployeeModelList(Arrays.asList(responseEntity.getBody()));
        return responseTemplateValueObj;
    }
}
