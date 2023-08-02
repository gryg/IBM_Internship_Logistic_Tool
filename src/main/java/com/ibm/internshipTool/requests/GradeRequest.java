package com.ibm.internshipTool.requests;

import java.util.Optional;

public class GradeRequest {
    private double grade;
    private String comment; // Optional field

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
