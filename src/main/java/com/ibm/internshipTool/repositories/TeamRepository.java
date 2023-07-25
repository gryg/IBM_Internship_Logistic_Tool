package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
        // methods to be added
}
