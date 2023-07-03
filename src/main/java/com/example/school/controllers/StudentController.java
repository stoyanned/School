package com.example.school.controllers;

import com.example.school.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/school/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();
    private int nextStudentId = 1;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        student.setId(nextStudentId++);
        students.add(student);
        return ResponseEntity.ok("Student added successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        students.removeIf(student -> student.getId() == id);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}