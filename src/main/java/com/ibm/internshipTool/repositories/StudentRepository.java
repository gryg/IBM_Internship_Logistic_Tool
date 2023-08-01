package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByTeamIdAndIsLeader(Long teamId, boolean isLeader);
    // methods to be added
    List<Student> findByTeamId(Long teamId);
    // Custom query to fetch students by team ID
    @Query("SELECT s FROM Student s WHERE s.team.id = ?1")
    List<Student> findAllByTeamId(Long teamId);
}
