package com.ibm.internshipTool.requests;

public class AttendanceUpdateRequest {
    private boolean status;

    public AttendanceUpdateRequest() {
    }

    public AttendanceUpdateRequest(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
