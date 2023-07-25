package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // methods to be added
}
