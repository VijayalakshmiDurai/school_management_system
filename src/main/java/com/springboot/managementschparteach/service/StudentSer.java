package com.springboot.managementschparteach.service;

import java.util.*;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.managementschparteach.model.Student;
import com.springboot.managementschparteach.repository.StudentRepo;

@Service
public class StudentSer {
    
    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

    public Student getStdByID(long ID){

        Optional<Student> model=studentRepo.findById(ID);

        if (model.isPresent())
        {
            return model.get();
        }
        return null;
    }
    public void deleteByStudentId(Long ID) { studentRepo.deleteById(ID); }

    public Student findById(Long id) {
        return null;
    }
}