package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Session, Long> {
    // methods to be added
}
