package com.departament_service.Departament_Service.Repository;

import com.departament_service.Departament_Service.Models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {

    @Override
    List<DepartmentModel> findAll();

    @Override
    DepartmentModel save(DepartmentModel s);

    @Override
    Optional<DepartmentModel> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
