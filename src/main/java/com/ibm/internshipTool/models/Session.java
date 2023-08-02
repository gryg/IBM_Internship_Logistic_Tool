package com.ibm.internshipTool.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "session", schema="public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column(name = "session_date")
    private LocalDate sessionDate;

    public Session() {
    }

    public Session(Long id, Activity activity, LocalDate sessionDate) {
        this.id = id;
        this.activity = activity;
        this.sessionDate = sessionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }


    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }
}
