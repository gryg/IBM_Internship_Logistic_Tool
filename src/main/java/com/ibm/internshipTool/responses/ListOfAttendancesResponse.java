package com.ibm.internshipTool.responses;

import java.util.List;

public class ListOfAttendancesResponse {
    private List<AttendanceResponse> attendances;

    // Constructors, getters, and setters

    public void setAttendances(List<AttendanceResponse> attendances) {
        this.attendances = attendances;
    }
}