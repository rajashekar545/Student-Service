package com.rajashekar.studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajashekar.studentservice.dto.StudentRequest;
import com.rajashekar.studentservice.entity.Student;
import com.rajashekar.studentservice.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Tag(name = "Student API", description = "Operations related to students")
public class StudentController {
	
	  
    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
    	this.studentService=studentService;
    }

    @PostMapping
    @Operation(summary = "Add a new student")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentRequest student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Student by id")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId) {
        Optional<Student> student = studentService.getStudentById(studentId);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Student by id")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId,
                                                 @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(studentId, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student by id")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        String message = studentService.deleteStudent(studentId);
        return ResponseEntity.ok(message);
    }

}
