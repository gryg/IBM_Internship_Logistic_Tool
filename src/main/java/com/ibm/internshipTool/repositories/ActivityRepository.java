package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // Add any custom queries if needed
}
