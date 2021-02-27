package com.user_service.User_Microservice.Initializer;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user_service.User_Microservice.Models.EmployeeModel;
import com.user_service.User_Microservice.Repository.EmployeeRepository;
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
    CommandLineRunner initDb(EmployeeRepository employeeRepository) throws IOException {
        return args -> {

            List<EmployeeModel> employeeModelList= this.readUserJson();

            for (EmployeeModel employeeModel: employeeModelList ) {
                employeeRepository.save(employeeModel);
            }

            log.info("Data for Employees Loaded");
        };
    }


    private List<EmployeeModel> readUserJson() throws IOException {
        return objectMapper.readValue(
                new File("src/main/resources/sampleData.json"),
                new TypeReference<List<EmployeeModel>>(){});
    }


}
