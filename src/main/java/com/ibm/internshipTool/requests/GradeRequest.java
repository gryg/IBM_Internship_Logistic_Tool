package com.ibm.internshipTool.requests;

public class GradeRequest {
    private double grade;

    public GradeRequest() {
    }

    public GradeRequest(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
