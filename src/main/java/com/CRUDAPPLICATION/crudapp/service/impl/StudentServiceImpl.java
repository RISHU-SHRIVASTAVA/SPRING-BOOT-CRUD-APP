package com.CRUDAPPLICATION.crudapp.service.impl;

import com.CRUDAPPLICATION.crudapp.dao.StudentDAO;
import com.CRUDAPPLICATION.crudapp.dto.StudentDTO;
import com.CRUDAPPLICATION.crudapp.mapper.StudentMapper;
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
        StudentDTO respStudentDTO = StudentMapper.toDTO(optionalStudent.get());

        return respStudentDTO;
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students=studentDAO.findAll();
        List<StudentDTO> respStudents=new ArrayList<>();

        for(Student student:students){
//            StudentDTO studentDTO=new StudentDTO();
//            studentDTO.setId(student.getId());
//            studentDTO.setName(student.getName());
//            studentDTO.setEmail(student.getEmail());

            respStudents.add(StudentMapper.toDTO(student)); //by using Mapper
        }
        return respStudents;
    }

    @Override
    public StudentDTO saveStudents(StudentDTO studentDTO) {
//        to save student we need to convert DTO to entity class i.e. StudentDTO to Student Class.
//        Student student=new Student();
        Student student=StudentMapper.toEntity(studentDTO);
//        student.setName(studentDTO.getName());
//        student.setEmail(studentDTO.getEmail());
        Student dbStudent= studentDAO.save(student); //this will save the student class
        // to generate studentDTO we need to convert Entity to DTO class i.e. Student class to StudentDTO class

//        StudentDTO respStudentDTO=new StudentDTO();
        StudentDTO respStudentDTO = StudentMapper.toDTO(dbStudent);
//        respStudentDTO.setId(dbStudent.getId());
//        respStudentDTO.setName(dbStudent.getName());
//        respStudentDTO.setEmail(dbStudent.getEmail());

        return respStudentDTO;
    }

    @Override
    public StudentDTO deleteStudent(long id) {
        //Fetching id of student
        Optional<Student> optionalStudent = studentDAO.findById(id);
        StudentDTO studentDTO=null;
        if(optionalStudent.isEmpty()){
            return studentDTO;
        }
        studentDAO.deleteById(id);

//        studentDTO=new StudentDTO();
//        studentDTO.setId(optionalStudent.get().getId());
//        studentDTO.setName(optionalStudent.get().getName());
//        studentDTO.setEmail(optionalStudent.get().getEmail());
        studentDTO = StudentMapper.toDTO(optionalStudent.get());
        return studentDTO;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student student= StudentMapper.toEntity(studentDTO);
        Student dbStudent= studentDAO.save(student);
        StudentDTO respStudent =StudentMapper.toDTO(dbStudent);
        return respStudent;
    }
}
