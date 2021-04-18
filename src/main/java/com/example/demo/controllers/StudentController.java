package com.example.demo.controllers;

import com.example.demo.Exceptions.StudentException;
import com.example.demo.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")

public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Abdullah"),
            new Student(2, "Kabiru"),
            new Student(3, "mujibat")
    );

    @GetMapping()
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @GetMapping({"studentId"})
    public Student getStudentById(@PathVariable Integer studentId) throws StudentException {
        return STUDENTS.stream().filter(student ->
                studentId.equals(student.getStudentId())).findFirst()
                .orElseThrow(() -> new StudentException(String.format("Student with %s does not exits", studentId)));
    }
}
