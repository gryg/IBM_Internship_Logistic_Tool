package com.example.teamManage.repository;

import com.example.teamManage.entity.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentsRepository extends JpaRepository<students,Long> {
}
