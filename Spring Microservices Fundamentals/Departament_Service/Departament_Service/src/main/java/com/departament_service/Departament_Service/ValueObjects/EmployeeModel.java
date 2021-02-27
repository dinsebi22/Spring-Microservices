package com.departament_service.Departament_Service.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long departmentId;

}
