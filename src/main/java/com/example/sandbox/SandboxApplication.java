package com.example.sandbox;

import com.example.sandbox.Student.student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
//add an annotation responsible for rest api
@RestController
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}
//	create a class
//	annotate the class
	@GetMapping
	public List<student> hello(){
		return List.of(
				new student(
						1L,
						"Donald",
						23,
						LocalDate.of(2000, Month.FEBRUARY, 26),
						"kibetdonald@gmail.com"
				)
		);
	}

}
