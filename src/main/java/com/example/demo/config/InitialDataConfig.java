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
            gradeRepository.deleteAll(); // clear table

            gradeRepository.saveAll(List.of(
                    new Grade(null, "Manager", 10),     // JANGAN pakai ID manual
                    new Grade(null, "Supervisor", 6),
                    new Grade(null, "Staff", 3)
            ));
        };
    }
}
