package com.springboot.managementschparteach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.managementschparteach.model.Parents;
import com.springboot.managementschparteach.repository.ParentsRepo;

@Service
public class ParentsSer {

    @Autowired
    private ParentsRepo parentsRepo;


    public Parents addParents(Parents parents){
        return parentsRepo.save(parents);
    }

}