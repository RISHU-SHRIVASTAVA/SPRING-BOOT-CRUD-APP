package com.CRUDAPPLICATION.crudapp.mapper;

import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;
import com.CRUDAPPLICATION.crudapp.model.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());
        return student;
    }
}
