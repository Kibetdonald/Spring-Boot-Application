package com.example.sandbox.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class studentService {

    //Add a reference to the studentRepository class
    private final studentRepository studentRespositorys;

    //Add a constructor and annotate with the @Autowired
    @Autowired
    public studentService(studentRepository studentRespositorys) {
        this.studentRespositorys = studentRespositorys;
    }

    public List<student> getStudent(){
        return studentRespositorys.findAll();
    }

    public void addNewStudent(student students) {
        System.out.println(students);
    }
}

