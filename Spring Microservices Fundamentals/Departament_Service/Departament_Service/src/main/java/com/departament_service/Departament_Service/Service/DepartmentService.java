package com.departament_service.Departament_Service.Service;

import com.departament_service.Departament_Service.Models.DepartmentModel;
import com.departament_service.Departament_Service.ResponseTemplate.ResponseTemplateValueObj;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<DepartmentModel> findAll();
    
    DepartmentModel save(DepartmentModel s);
    
    Optional<DepartmentModel> findById(Long aLong);
    
    void deleteById(Long aLong);

    ResponseTemplateValueObj findEmployeesForDepartment(Long id);
}
