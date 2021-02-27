package com.user_service.User_Microservice.Controller;

import com.user_service.User_Microservice.Models.EmployeeModel;
import com.user_service.User_Microservice.ResponseTemplates.ResponseTemplateValueObj;
import com.user_service.User_Microservice.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/employeeService")
public class EmployeeController {
    
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
        log.info("Generated Employee Controller");
    }

    @GetMapping(path = "/getEmployees")
    public List<EmployeeModel> findAll() {
        return this.employeeService.findAll();
    }

    @PostMapping(path = "/addEmployee")
    public EmployeeModel save(@RequestBody EmployeeModel employeeModel) {
        log.info("Adding Employee");
        return this.employeeService.save(employeeModel);
    }

    @GetMapping(path = "/getEmployee/{id}")
    public EmployeeModel findById(@PathVariable("id") Long id) {
        log.info("Getting Employee with Id: " + id);
        return employeeService.findById(id).get();
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.warn("Deleting Employee with Id: " + id);
        this.employeeService.deleteById(id);
    }

    @GetMapping(path = "/getEmployeeWithDepartment/{id}")
    public ResponseTemplateValueObj getEmployeeWithDepartment(@PathVariable("id") Long employeeId){
        return this.employeeService.getEmployeeWithDepartment(employeeId);
    }

    @GetMapping(path = "/findEmployeesForDepartment/{departmentId}")
    public EmployeeModel[] findEmployeesForDepartment(@PathVariable("departmentId") Long departmentId){
        //        The problem is due to type erasure with Java generics. When the application is running,
        //        it has no knowledge of what type of object is in the list.
        //        This means the data in the list cannot be deserialized into the appropriate type.
        EmployeeModel[] employees = this.employeeService.findEmployeesForDepartment(departmentId).toArray(new EmployeeModel[0]);
        return employees;
    }
    
}
