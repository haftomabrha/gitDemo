package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository
    ){
        return args -> {
           Student med= new Student(
                    1L,
                    "medihin",
                    "medi83@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER,5)

            );

            Student haf= new Student(
                    1L,
                    "haftom",
                    "haftom83@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER,5)

            );
            //repository.saveAll(List.of(med,haf));
        };


    }

}
