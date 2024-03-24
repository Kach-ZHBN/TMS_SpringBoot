package by.teachmeskills.kachzhbn.springboot.controller;

import by.teachmeskills.kachzhbn.springboot.model.Student;
import by.teachmeskills.kachzhbn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "student/students";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/student-page";
    }

    @GetMapping("/new")
    public String getNewStudentForm(Model model){
        model.addAttribute("newStudent", new Student());
        return "student/new-student-page";
    }

    @PostMapping("")
    public String createNewStudent(@ModelAttribute("newStudent") Student newStudent){
        studentService.createNewStudent(newStudent);
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String getEditStudentForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/edit-student-page";
    }

    @PatchMapping("/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        return "redirect:/student/" + id;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/student";
    }
}
