package com.ibm.internshipTool.services;

import com.ibm.internshipTool.models.Activity;
import com.ibm.internshipTool.models.Student;
import com.ibm.internshipTool.models.Team;
import com.ibm.internshipTool.repositories.ActivityRepository;
import com.ibm.internshipTool.repositories.StudentRepository;
import com.ibm.internshipTool.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamLeaderService {

    private final TeamRepository teamRepository;
    private final StudentRepository studentRepository;
    private final ActivityRepository activityRepository; // Add this field


    @Autowired
    public TeamLeaderService(TeamRepository teamRepository, StudentRepository studentRepository, ActivityRepository activityRepository) {
        this.teamRepository = teamRepository;
        this.studentRepository = studentRepository;
        this.activityRepository = activityRepository;
    }

    @Transactional
    public boolean enrollTeamInActivity(Long teamId, Long activityId) {
        // Check if the team exists
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) {
            return false;
        }

        // Enroll the team in the activity by setting the activity_id

        // Find the activity by its ID
        Activity activity = activityRepository.findById(activityId).orElse(null);
        if (activity == null) {
            return false;
        }
        team.setActivityId(activity);
        teamRepository.save(team);
        return true;
    }

    @Transactional
    public boolean addStudentToTeam(Long teamId, Long studentId) {
        // Check if the team and student exist
        Team team = teamRepository.findById(teamId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        if (team == null || student == null) {
            return false;
        }

        // Add the student to the team by setting the team_id in the student record
        student.setTeam(team);
        studentRepository.save(student);
        return true;
    }

    @Transactional
    public boolean deleteStudentFromTeam(Long studentId) {
        // Check if the student exists
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            return false;
        }

        // Remove the student from the team by setting the team_id to null in the student record
        student.setTeam(null);
        studentRepository.save(student);
        return true;
    }
}
