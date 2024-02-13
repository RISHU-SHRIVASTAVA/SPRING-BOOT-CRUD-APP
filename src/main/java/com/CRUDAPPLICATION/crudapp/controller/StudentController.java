package com.CRUDAPPLICATION.crudapp.controller;


import com.CRUDAPPLICATION.crudapp.dao.StudentDAO;
import com.CRUDAPPLICATION.crudapp.dto.ApiResponse;
import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;
import com.CRUDAPPLICATION.crudapp.model.Student;
import com.CRUDAPPLICATION.crudapp.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

   @GetMapping("/students/{id}")
    public ApiResponse getStudent(@PathVariable long id){
        ApiResponse apiResponse=new ApiResponse();
        StudentDTO studentDTO=studentService.getStudent(id);
        if(studentDTO!=null){
            apiResponse.setStatus("Success");
            apiResponse.setError(null);
            apiResponse.setPath(null);
            apiResponse.setData(studentDTO);
            apiResponse.setApiTimeStamp(new Date());
        }
       return apiResponse;
   }
    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
       return studentService.saveStudents(studentDTO);
    }
    @DeleteMapping("/students/{id}")
    public StudentDTO deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/students")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }
}
