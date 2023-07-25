package com.ibm.internshipTool.services;


import com.ibm.internshipTool.repositories.GradeRepository;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    // methods for CRUD operations or custom business logic
}
