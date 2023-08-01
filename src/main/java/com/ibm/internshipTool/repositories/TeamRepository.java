package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t FROM Team t WHERE t.activity.id = :activityId AND t.leader.id = :leaderId")
    Optional<Team> findByActivityIdAndLeaderId(Long activityId, Long leaderId);
//    List<Team> findByActivityId(Long activityId);
    @Query("SELECT t FROM Team t WHERE t.activity.id = :activityId")
    List<Team> findByActivityId(@Param("activityId") Long activityId);
}
