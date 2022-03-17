package com.crudApp.controllers;

import com.crudApp.entities.Student;
import com.crudApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentform")
    public String showform(Model m){
        m.addAttribute("command", new Student());
        return "studentform";
    }

//    @RequestMapping(path="/studentform")
//    public String showform(Student student,Model model) {
//        model.addAttribute("student", new Student());
//        return "studentform";
//    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student){
        System.out.println("inside save mapping : "+student);
        studentService.save(student);
        return "redirect:/viewstudent";
    }

    @RequestMapping("/viewstudent")
    public ModelAndView viewstudent(){
        List<Student> studentLst=studentService.getAllStudentsDetail();
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(" inside viewstudent controller All student List : "+studentLst);
        modelAndView.addObject("studentLst",studentLst);
        modelAndView.setViewName("viewstudent");
        return modelAndView;
    }
//    @RequestMapping("/viewstudent")
//    public String viewstudent(Model m){
//        List<Studentt> studentLst=dao.getAllStudentsDetail();
//        m.ad////dAttribute("studentLst",studentLst);
//        return "viewstudent";
//    }

    @RequestMapping(value="/editstudent/{rollNo}")
    public String edit(@PathVariable int rollNo, Model m){
        Student student=studentService.getStudentByRollNo(rollNo);
        m.addAttribute("student",student);
        return "studenteditform";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Student student){
        studentService.update(student);
        return "redirect:/viewstudent";
    }

    @RequestMapping(value="/deletestudent/{rollNo}")
    public String delete(@PathVariable int rollNo){
        studentService.delete(rollNo);
        return "redirect:/viewstudent";
    }
}
