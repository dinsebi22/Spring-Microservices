package com.user_service.User_Microservice.Repository;

import com.user_service.User_Microservice.Models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    @Override
    List<EmployeeModel> findAll();

    @Override
    EmployeeModel save(EmployeeModel employeeModel);

    @Override
    Optional<EmployeeModel> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    List<EmployeeModel> saveAll(Iterable iterable);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE " +
            "EMPLOYEE.DEPARTMENT_ID = ? ", nativeQuery = true)
    List<EmployeeModel> findEmployeesForDepartment(Long id);
}
