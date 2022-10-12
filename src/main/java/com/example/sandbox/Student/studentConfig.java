package com.example.sandbox.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.FEBRUARY;


@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return  args ->{
       student Donald = new student(
                        "Donald",
                        LocalDate.of(2000, FEBRUARY, 26),
                        "kibetdonald@gmail.com"
                );
            student Doreen = new student(
                    "Doreen",
                    LocalDate.of(2002, Month.AUGUST, 8),
                    "doreen@gmail.com"
            );
            repository.saveAll(
                    List.of(Donald, Doreen)
            );
        };
    }

}
