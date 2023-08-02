package com.ibm.internshipTool.responses;

import java.util.List;

public class ListOfAttendancesResponse {
    private List<AttendanceResponse> attendances;

    public List<AttendanceResponse> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<AttendanceResponse> attendances) {
        this.attendances = attendances;
    }
}
