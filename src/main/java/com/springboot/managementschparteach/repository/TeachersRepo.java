package com.springboot.managementschparteach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.managementschparteach.model.Teachers;

@Repository
public interface TeachersRepo extends JpaRepository<Teachers,Long> {
}