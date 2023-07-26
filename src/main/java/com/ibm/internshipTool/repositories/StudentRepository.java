package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByTeamIdAndIsLeader(Long teamId, boolean isLeader);
    // methods to be added
}
