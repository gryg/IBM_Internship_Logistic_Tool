package com.example.teamManage.entity;

import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name = "GRADES", schema = "public")
public class grades {
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

    @Column(name = "grade")
    private DecimalFormat grade;

    @Column(name = "comment")
    private String comment;

 public grades() {
 }

 public grades(Long id, Long studentID, Long sessionID, Long mentorID, DecimalFormat grade, String comment) {
  this.id = id;
  this.studentID = studentID;
  this.sessionID = sessionID;
  this.mentorID = mentorID;
  this.grade = grade;
  this.comment = comment;
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

 public DecimalFormat getGrade() {
  return grade;
 }

 public void setGrade(DecimalFormat grade) {
  this.grade = grade;
 }

 public String getComment() {
  return comment;
 }

 public void setComment(String comment) {
  this.comment = comment;
 }
}
