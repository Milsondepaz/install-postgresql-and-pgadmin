package com.milsondev.banco.service;

import com.milsondev.banco.db.entity.Student;
import com.milsondev.banco.db.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    private void addStudentToDB(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(UUID.randomUUID() , "Milson", "Angola"));
        studentList.add(new Student(UUID.randomUUID() , "Gulnara", "Russia"));
        studentList.add(new Student(UUID.randomUUID() , "Hanna", "Brazil"));
        studentList.add(new Student(UUID.randomUUID() , "Silva", "Portugal"));
        studentList.add(new Student(UUID.randomUUID() , "Julia", "Colombia"));
        studentRepository.saveAll(studentList);
    }

}
