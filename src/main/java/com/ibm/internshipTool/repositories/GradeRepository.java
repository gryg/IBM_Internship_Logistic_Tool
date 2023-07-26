package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findBySessionActivityIdAndStudentId(Long activityId, Long studentId);

    Grade findBySessionActivityIdAndSessionIdAndStudentId(Long activityId, Long sessionId, Long studentId);
//    List<Grade> findBySessionActivityId(Long activityId);
//    @Query("SELECT g FROM Grade g " +
//            "JOIN Session s ON g.session_id = s.id " +
//            "JOIN Activity a ON s.activity_id = a.id " +
//            "WHERE a.id = :activityId")

    Optional<Grade> findByStudentIdAndSessionId(Long studentId, Long sessionId);

    List<Grade> getGradesByActivity(@Param("activityId") Long activityId);

//    List<Grade> getGradesByActivity();
}
