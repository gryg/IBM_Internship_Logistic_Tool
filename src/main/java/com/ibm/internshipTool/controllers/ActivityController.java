package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.models.Grade;
import com.ibm.internshipTool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    private final StudentService studentService;

    @Autowired
    public ActivityController(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    @GetMapping("/{activityId}/student/{studentId}/grade")
    public <Grade>
        the given activity and student

        List<Grade> grades = new ArrayList<>();
        ListOfGradesResponse response = new ListOfGradesResponse();
        response.setGrades(grades);
        return ResponseEntity.ok(response);
    }
}
