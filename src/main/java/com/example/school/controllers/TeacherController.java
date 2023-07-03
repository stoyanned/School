package com.example.school.controllers;

import com.example.school.entities.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/school/teachers")
public class TeacherController {
    private List<Teacher> teachers = new ArrayList<>();
    private int nextTeacherId = 1;

    @PostMapping
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        teacher.setId(nextTeacherId++);
        teachers.add(teacher);
        return ResponseEntity.ok("Teacher added successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teachers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
        teachers.removeIf(teacher -> teacher.getId() == id);
        return ResponseEntity.ok("Teacher deleted successfully.");
    }
}