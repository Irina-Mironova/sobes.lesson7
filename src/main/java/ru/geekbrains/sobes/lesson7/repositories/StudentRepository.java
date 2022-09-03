package ru.geekbrains.sobes.lesson7.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.sobes.lesson7.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
}
