package com.CRUDAPPLICATION.crudapp.service;

import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO getStudent(long id);
    List<StudentDTO> getStudents();
    StudentDTO saveStudents(StudentDTO studentDTO);
    StudentDTO deleteStudent(long id);
}
