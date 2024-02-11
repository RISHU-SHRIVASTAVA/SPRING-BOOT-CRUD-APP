package com.CRUDAPPLICATION.crudapp.controller;


import com.CRUDAPPLICATION.crudapp.dao.StudentDAO;
import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;
import com.CRUDAPPLICATION.crudapp.model.Student;
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
    private StudentDAO studentDAO;

   @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable long id){
       Optional<Student> optionalStudent = studentDAO.findById(id);
       StudentDTO studentDTO=null;
       if(optionalStudent.isEmpty()){
           return studentDTO;
       }
       studentDTO=new StudentDTO();
       studentDTO.setId(optionalStudent.get().getId());
       studentDTO.setName(optionalStudent.get().getName());
       studentDTO.setEmail(optionalStudent.get().getEmail());

       return studentDTO;
    }
    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
       List<Student> students=studentDAO.findAll();
        List<StudentDTO> respStudents=new ArrayList<>();

        for(Student student:students){
            System.out.println(student);
        }
        return null;
    }
}
