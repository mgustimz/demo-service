package com.example.demo.config;

import com.example.demo.employee.persistence.Grade;
import com.example.demo.employee.persistence.GradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitialDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(GradeRepository gradeRepository) {
        return args -> {
            Grade manager = new Grade(1L, "Manager", 10);
            Grade supervisor = new Grade(2L, "Supervisor", 6);
            Grade staff = new Grade(3L, "Staff", 3);

            gradeRepository.saveAll(List.of(manager, supervisor, staff));
        };
    }
}
