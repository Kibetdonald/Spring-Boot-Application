package com.example.sandbox.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//add an annotation responsible for rest api
@RestController
@RequestMapping(path="api/v1/student")
public class studentController {
//     the controller class is responsible for processing
//     incoming REST API requests, preparing a model, and
//     returning the view to be rendered as a response.
@GetMapping
public List<student> getStudent(){
    return List.of(
            new student(
                    1L,
                    "Donald",
                    23,
                    LocalDate.of(2000, Month.FEBRUARY, 26),
                    "kibetdonald@gmail.com"
            ),
            new student(
                    2L,
                    "Doreen",
                    23,
                    LocalDate.of(2002, Month.FEBRUARY, 17),
                    "kibetdonald@gmail.com"
            )
    );
}
}

