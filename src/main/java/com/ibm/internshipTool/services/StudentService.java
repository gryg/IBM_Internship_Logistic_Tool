package com.ibm.internshipTool.services;

import com.ibm.internshipTool.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // methods for CRUD operations or custom business logic
}
