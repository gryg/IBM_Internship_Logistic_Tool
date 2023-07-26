package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findBySessionActivityIdAndStudentId(Long activityId, Long studentId);

    Grade findBySessionActivityIdAndSessionIdAndStudentId(Long activityId, Long sessionId, Long studentId);
    List<Grade> findBySessionActivityId(Long activityId);

//    List<Grade> getGradesByActivity();
}
