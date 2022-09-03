package ru.geekbrains.sobes.lesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sobes.lesson7.entities.Student;
import ru.geekbrains.sobes.lesson7.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students_all";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findById(id));
        return "student_info";
    }

    @RequestMapping("/student_add")
    public String productAdd(Model uiModel) {
        Student student = new Student();
        uiModel.addAttribute("student", student);
        return "student_add";
    }


    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(Model model, @PathVariable Long id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student_update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/students";
    }


}
