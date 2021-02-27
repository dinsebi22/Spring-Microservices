package com.user_service.User_Microservice.ResponseTemplates;

import com.user_service.User_Microservice.Models.EmployeeModel;
import com.user_service.User_Microservice.ValueObjects.DepartmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObj {

    private EmployeeModel employeeModel;
    private DepartmentModel departmentModel;


}
