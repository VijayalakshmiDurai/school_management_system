package com.springboot.managementschparteach.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.managementschparteach.model.Parents;
import com.springboot.managementschparteach.model.Student;
import com.springboot.managementschparteach.service.ParentsSer;
import com.springboot.managementschparteach.service.StudentSer;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class StudentsCon {

    @Autowired
    private StudentSer studentSer;
    @Autowired
    private ParentsSer parentsSer;
    @Autowired
    private StudentSer studentRepo;



    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student, @ModelAttribute Parents parent, Model model, HttpSession session){
//        System.out.println("type added");
//        StudentSer.addStudent(Student);

        Parents temp = parentsSer.addParents(parent);

        student.setParents(temp);

        studentSer.addStudent(student);

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());
        session.setAttribute("msg","Student Added Sucessfully...");
        return "StudentAdd";
    }

    @PostMapping("/AssignSubjectConform")
    public String AssignSubjectConform(@ModelAttribute Student student, Model model){
//        System.out.println("type added");
//        StudentSer.addStudent(Student);
        Student student1=studentRepo.findById(student.getID()).get();
        student1.setSubjects(student.getSubjects());




        studentSer.addStudent(student1);

        List<Student> student2 =studentSer.getStudent();
        model.addAttribute("student",  student2);

        return "Studentshow";
    }


    @GetMapping("/Student")
    public String Student(Model model){

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());

        return "StudentsAdd";


    }

    @GetMapping("/")
    public String Home(Model model){

        return "add";

    }

    @GetMapping("/Studentshow")
    public String Studentshow(Model model){
        List<Student> student =studentSer.getStudent();
        model.addAttribute("student",  student);
        return "Studentsshow";
    }

    @GetMapping("/Studentshow/edit/{ID}")
    public String edit(@PathVariable("ID") long ID, Model m){

        Student student = studentSer.getStdByID(ID);

        m.addAttribute("student", student);

        return "StudentEdit";
    }

    @PostMapping("Studentsshow/edit/UpdateStudent")
    public String UpdateStudent(@ModelAttribute Student student, Model model, HttpSession session){

        studentSer.addStudent(student);

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());
        session.setAttribute("msg","Student Added Sucessfully...");
        return "StudentEdit";
    }

    @GetMapping("/Studentshow/delete/{ID}")
    public String deleteStudent(@PathVariable("ID") Long ID, HttpSession session) {
        studentSer.deleteByStudentId(ID);
        session.setAttribute("msg", "The User ID " + ID + " Deleted Succesfully");
        return "redirect:/Studentshow";
    }

//    @GetMapping("/Studentshow/delete/{ID}")
//    public String DeleteStd(@PathVariable("ID") long ID){
//
//    }
}
