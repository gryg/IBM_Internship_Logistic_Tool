package com.ibm.internshipTool.responses;

import java.util.List;

public class ListOfGradesResponse {
    private List<GradeResponse> grades;

    public List<GradeResponse> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeResponse> grades) {
        this.grades = grades;
    }
}
