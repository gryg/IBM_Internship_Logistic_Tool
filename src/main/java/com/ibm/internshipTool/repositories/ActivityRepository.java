package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {

}
