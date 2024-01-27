package com.springboot.managementschparteach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.managementschparteach.model.Subjects;

@Repository
public interface SubjectsRepo extends JpaRepository<Subjects,Long> {
}