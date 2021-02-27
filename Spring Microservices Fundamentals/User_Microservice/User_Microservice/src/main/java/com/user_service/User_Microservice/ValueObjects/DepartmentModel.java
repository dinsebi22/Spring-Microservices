package com.user_service.User_Microservice.ValueObjects;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {

    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentLocation;

}
