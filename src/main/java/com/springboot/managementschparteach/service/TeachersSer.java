package com.springboot.managementschparteach.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.managementschparteach.model.Student;
import com.springboot.managementschparteach.model.Teachers;
import com.springboot.managementschparteach.repository.TeachersRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersSer {
    @Autowired
    private TeachersRepo teacherRepo;
    public Teachers addTeacher(Teachers teachers){
        return teacherRepo.save(teachers);
    }

    public List<Teachers> getTeachers(){

        return teacherRepo.findAll();
    }

    public Teachers getteaByID(long ID) {

        Optional<Teachers> model=teacherRepo.findById(ID);

        if (model.isPresent())
        {
            return model.get();
        }
        return null;
    }

    
     public void deleteByStudentId(Long ID) { teacherRepo.deleteById(ID); }

    public Student findById(Long id) {
        return null;
    }
}
