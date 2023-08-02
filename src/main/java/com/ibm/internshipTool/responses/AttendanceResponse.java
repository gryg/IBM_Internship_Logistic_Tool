package com.ibm.internshipTool.responses;

public class AttendanceResponse {
    private String date;
    private boolean status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}