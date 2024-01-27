package com.springboot.managementschparteach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.managementschparteach.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{
    
}
