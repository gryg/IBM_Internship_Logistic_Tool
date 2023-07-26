package com.ibm.internshipTool.models;

import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name = "grades", schema="public")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    //@Column ?
    private Double grade;

    //@Column ?
    private String comment;

    public Grade() {
    }

    public Grade(Long id, Student student, Mentor mentor, Session session, Double grade, String comment) {
        this.id = id;
        this.student = student;
        this.mentor = mentor;
        this.session = session;
        this.grade = grade;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
