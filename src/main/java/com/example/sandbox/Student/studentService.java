package com.example.sandbox.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<student> studentOptional = studentRespositorys
                .findStudentByEmail(students.getEmail());
        if(studentOptional.isPresent()){
throw new IllegalStateException("The email has been registered");
        }
        studentRespositorys.save(students);
    }

    public void deleteStudent(Long studentsId) {
       boolean exists = studentRespositorys.existsById(studentsId);
       if(!exists){
           throw new IllegalStateException(
                   "Student with id" + " "+ studentsId + " "+"does not exists");

       }
        studentRespositorys.deleteById(studentsId);
    }
@Transactional
    public void updateStudents(Long studentsId, String name, String email) {
        student students = studentRespositorys.findById(studentsId)
                .orElseThrow(()-> new IllegalStateException(
                        "Student with id" + " "+ studentsId + " "+"does not exists"));

                if(name != null && !Objects.equals(students.getName(), name)){
                    students.setName(name);
                }

                if(email != null && email.length() > 0 &&
                            !Objects.equals(students.getEmail(), email)){
                    Optional<student> studentOptional = studentRespositorys.findStudentByEmail(email);
                    if(studentOptional.isPresent()){
                        throw new IllegalStateException("Email Taken");
                    }
                    students.setEmail(email);
                }
    }
}

