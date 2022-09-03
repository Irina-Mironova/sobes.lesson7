package ru.geekbrains.sobes.lesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.sobes.lesson7.entities.Student;
import ru.geekbrains.sobes.lesson7.repositories.StudentRepository;


import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Студента с id " + id + " не существует"));
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student) {
        Student studentUpdate = studentRepository.findById(student.getId()).orElseThrow(() ->
                new RuntimeException("Студента с id " + student.getId() + " не существует"));
        studentUpdate.setName(student.getName());
        studentUpdate.setAge(student.getAge());
        studentRepository.save(studentUpdate);

    }

    public void deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Студента с id " + id + " не существует"));
        studentRepository.delete(student);
    }


    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
