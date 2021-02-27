package com.departament_service.Departament_Service.ResponseTemplate;

import com.departament_service.Departament_Service.Models.DepartmentModel;
import com.departament_service.Departament_Service.ValueObjects.EmployeeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObj {

    private DepartmentModel departmentModel;
    private List<EmployeeModel> employeeModelList;

}
