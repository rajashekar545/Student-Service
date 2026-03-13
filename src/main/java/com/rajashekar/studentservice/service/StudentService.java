package com.rajashekar.studentservice.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajashekar.studentservice.dto.StudentRequest;
import com.rajashekar.studentservice.entity.Student;
import com.rajashekar.studentservice.mapper.StudentMapper;
import com.rajashekar.studentservice.repository.StudentRepository;

@Service
public class StudentService {

    private static final Logger logger = LogManager.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        logger.info("Fetching student by id: {}", studentId);
        return studentRepository.findById(studentId);
    }

    public Student addStudent(StudentRequest request) {

        logger.info("Adding new student: {}", request.getStudentName());

        Student student = studentMapper.toEntity(request);

        Student savedStudent = studentRepository.save(student);

        logger.info("Student added successfully with id: {}", savedStudent.getStudentId());

        return savedStudent;
    }

    public Student updateStudent(Long studentId, Student studentDetails) {

        logger.info("Updating student with id: {}", studentId);

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    logger.error("Student not found with id: {}", studentId);
                    return new RuntimeException("Student not found with id: " + studentId);
                });

        existingStudent.setStudentName(studentDetails.getStudentName());
        existingStudent.setGrade(studentDetails.getGrade());
        existingStudent.setMobileNumber(studentDetails.getMobileNumber());
        existingStudent.setSchoolName(studentDetails.getSchoolName());

        Student updatedStudent = studentRepository.save(existingStudent);

        logger.info("Student updated successfully with id: {}", studentId);

        return updatedStudent;
    }

    public String deleteStudent(Long studentId) {

        logger.info("Deleting student with id: {}", studentId);

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    logger.error("Student not found for deletion with id: {}", studentId);
                    return new RuntimeException("Student not found with id: " + studentId);
                });

        studentRepository.delete(existingStudent);

        logger.info("Student deleted successfully with id: {}", studentId);

        return "Student deleted successfully with id: " + studentId;
    }
}