package com.springboot.managementschparteach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.managementschparteach.model.Parents;

@Repository
public interface ParentsRepo extends JpaRepository<Parents,Long> {
}
