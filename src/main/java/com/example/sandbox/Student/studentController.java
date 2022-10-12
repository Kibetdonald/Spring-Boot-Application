package com.example.sandbox.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//    let's have a reference to the student service
    private final studentService studentServices;

    @Autowired
    public studentController(studentService studentServices) {
        this.studentServices = studentServices;
    }


@GetMapping
public List<student> getStudent(){
    return studentServices.getStudent();
}

//Post request
    @PostMapping
    public void registerNewStudent(@RequestBody student students){
        studentServices.addNewStudent(students);
    }
    @DeleteMapping(path="{studentsId}")
    public void deleteStudent(@PathVariable("studentsId") Long studentsId){
        studentServices.deleteStudent(studentsId);
    }
    @PutMapping(path="{studentsId}")
    public void updateStudent(
            @PathVariable("studentsId") Long studentsId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        studentServices.updateStudents(studentsId, name, email);
    }
}


