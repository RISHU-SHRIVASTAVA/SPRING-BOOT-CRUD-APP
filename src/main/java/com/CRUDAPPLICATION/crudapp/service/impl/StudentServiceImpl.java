package com.CRUDAPPLICATION.crudapp.service.impl;

import com.CRUDAPPLICATION.crudapp.dao.StudentDAO;
import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;
import com.CRUDAPPLICATION.crudapp.model.Student;
import com.CRUDAPPLICATION.crudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;
    @Override
    public StudentDTO getStudent(long id) {
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

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students=studentDAO.findAll();
        List<StudentDTO> respStudents=new ArrayList<>();

        for(Student student:students){
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setEmail(student.getEmail());

            respStudents.add(studentDTO);
        }
        return respStudents;
    }
}
