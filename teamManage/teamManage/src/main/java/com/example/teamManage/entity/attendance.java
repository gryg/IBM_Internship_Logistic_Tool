package com.example.teamManage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ATTENDANCE",schema="public")
public class attendance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "studentID")
    private Long studentID;

    @Column(name = "sessionId")
    private Long sessionID;

    @Column(name = "mentorId")
    private Long mentorID;

    @Column(name = "attendance")
    private Boolean attendance;

    public attendance() {
    }

    public attendance(Long id, Long studentID, Long sessionID, Long mentorID, Boolean attendance) {
        this.id = id;
        this.studentID = studentID;
        this.sessionID = sessionID;
        this.mentorID = mentorID;
        this.attendance = attendance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public Long getMentorID() {
        return mentorID;
    }

    public void setMentorID(Long mentorID) {
        this.mentorID = mentorID;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }
}
