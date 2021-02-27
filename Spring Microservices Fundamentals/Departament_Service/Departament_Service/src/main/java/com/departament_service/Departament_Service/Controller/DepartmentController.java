package com.departament_service.Departament_Service.Controller;


import com.departament_service.Departament_Service.Models.DepartmentModel;
import com.departament_service.Departament_Service.ResponseTemplate.ResponseTemplateValueObj;
import com.departament_service.Departament_Service.Service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/departmentService")
public class DepartmentController {

    private DepartmentService departmentService;

//    http://localhost:9191/departmentService/getAllDepartments now we use this URL
//    to do our request because of our Defined API-Gateway
//    which is opened on port 9191

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/getAllDepartments")
    public List<DepartmentModel> findAll() {
        return this.departmentService.findAll();
    }

    @PostMapping(path = "/saveDepartment")
    public DepartmentModel save(@RequestBody DepartmentModel departmentModel) {
        return this.departmentService.save(departmentModel);
    }

    @GetMapping(path = "/getDepartment/{id}")
    public Optional<DepartmentModel> findById(@PathVariable Long id) {
        return this.departmentService.findById(id);
    }

    @DeleteMapping(path = "/deleteDepartment/{id}")
    public void deleteById(@PathVariable Long id) {
        this.departmentService.deleteById(id);
    }

    @GetMapping(path = "/getEmployeesForDepartment/{id}")
    public ResponseTemplateValueObj getEmployeesForDepartment(@PathVariable("id") Long id){
        return this.departmentService.findEmployeesForDepartment(id);
    }

}
