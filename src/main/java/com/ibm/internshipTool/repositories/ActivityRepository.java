package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("SELECT s.activity.id FROM Session s WHERE s.id = :sessionId")
    Long findActivityIdBySessionId(@Param("sessionId") Long sessionId);
}
