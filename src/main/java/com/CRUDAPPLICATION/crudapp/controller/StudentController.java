package com.CRUDAPPLICATION.crudapp.controller;


import com.CRUDAPPLICATION.crudapp.dao.StudentDAO;
import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;
import com.CRUDAPPLICATION.crudapp.model.Student;
import com.CRUDAPPLICATION.crudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

   @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable long id){
        return studentService.getStudent(id);
   }
    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }
}
