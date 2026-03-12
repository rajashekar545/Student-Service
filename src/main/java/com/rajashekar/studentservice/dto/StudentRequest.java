package com.rajashekar.studentservice.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class StudentRequest implements Serializable{

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotBlank(message = "Grade is required")
    private String grade;

    @Pattern(regexp="\\d{10}", message="Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "School name is required")
    private String schoolName;

    
    
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}