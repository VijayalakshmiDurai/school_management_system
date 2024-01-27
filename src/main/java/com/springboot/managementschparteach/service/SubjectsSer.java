package com.springboot.managementschparteach.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.managementschparteach.model.Subjects;
import com.springboot.managementschparteach.repository.SubjectsRepo;


import java.util.List;

@Service
public class SubjectsSer {
    @Autowired
    private SubjectsRepo subjectsRepo;
    public Subjects addSubjects(Subjects subjects) {return subjectsRepo.save(subjects);
    }

    public List<Subjects> getAllSubjects(){
        return subjectsRepo.findAll();
    }


}