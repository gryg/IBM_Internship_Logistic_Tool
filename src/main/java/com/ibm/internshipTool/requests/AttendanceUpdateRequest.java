package com.ibm.internshipTool.requests;

public class AttendanceUpdateRequest {
    private boolean attendance;

    // Constructors, getters, and setters

    public AttendanceUpdateRequest() {
    }

    public AttendanceUpdateRequest(boolean attendance) {
        this.attendance = attendance;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}
