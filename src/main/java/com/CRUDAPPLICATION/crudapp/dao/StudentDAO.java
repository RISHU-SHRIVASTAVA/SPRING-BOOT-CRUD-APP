package com.CRUDAPPLICATION.crudapp.dao;

import com.CRUDAPPLICATION.crudapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student,Long> {
}
