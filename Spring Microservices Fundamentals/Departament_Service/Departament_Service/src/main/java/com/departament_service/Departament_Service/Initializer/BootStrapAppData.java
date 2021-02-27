package com.departament_service.Departament_Service.Initializer;


import com.departament_service.Departament_Service.Models.DepartmentModel;
import com.departament_service.Departament_Service.Repository.DepartmentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Configuration
public class BootStrapAppData {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Bean
    CommandLineRunner initDb(DepartmentRepository employeeRepository) throws IOException {
        return args -> {

            List<DepartmentModel> departmentModels= this.readUserJson();

            for (DepartmentModel employeeModel: departmentModels ) {
                employeeRepository.save(employeeModel);
            }

            log.info("Data for Departments Loaded");
        };
    }


    private List<DepartmentModel> readUserJson() throws IOException {
        return objectMapper.readValue(
                new File("src/main/resources/sampleData.json"),
                new TypeReference<List<DepartmentModel>>(){});
    }


}
