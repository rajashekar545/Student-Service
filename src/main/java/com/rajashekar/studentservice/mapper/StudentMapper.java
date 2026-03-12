package com.rajashekar.studentservice.mapper;

import org.mapstruct.Mapper;

import com.rajashekar.studentservice.dto.StudentRequest;
import com.rajashekar.studentservice.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest request);
}
