package com.rajashekar.studentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajashekar.studentservice.dto.StudentRequest;
import com.rajashekar.studentservice.entity.Student;
import com.rajashekar.studentservice.mapper.StudentMapper;
import com.rajashekar.studentservice.repository.StudentRepository;

@Service
public class StudentService {
  
	private final StudentRepository studentRepository;  
	
	@Autowired	private StudentMapper studentMapper;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student addStudent(StudentRequest request) {
    	
    	Student student = studentMapper.toEntity(request);;

        return studentRepository.save(student);
    }
    
    public Student updateStudent(Long studentId, Student studentDetails) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        existingStudent.setStudentName(studentDetails.getStudentName());
        existingStudent.setGrade(studentDetails.getGrade());
        existingStudent.setMobileNumber(studentDetails.getMobileNumber());
        existingStudent.setSchoolName(studentDetails.getSchoolName());

        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(Long studentId) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        studentRepository.delete(existingStudent);
        return "Student deleted successfully with id: " + studentId;
    }
}
