package com.ibm.internshipTool.services;

import com.ibm.internshipTool.models.Student;
import com.ibm.internshipTool.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // methods for CRUD operations or custom business logic
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
}
