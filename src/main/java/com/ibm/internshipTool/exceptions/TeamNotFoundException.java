package com.ibm.internshipTool.exceptions;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException() {
        super();
    }

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamNotFoundException(Throwable cause) {
        super(cause);
    }
}