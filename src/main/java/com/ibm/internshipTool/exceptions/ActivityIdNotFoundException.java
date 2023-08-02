package com.ibm.internshipTool.exceptions;

public class ActivityIdNotFoundException extends RuntimeException {
    public ActivityIdNotFoundException(String message) {
        super(message);
    }
}