package com.example.SpringDataJpaDemo.service;

import com.example.SpringDataJpaDemo.entity.Student;
import com.example.SpringDataJpaDemo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not found"));
    }

    public List<Student> findAll() {

        Sort sort = Sort.by("age").ascending();

        return studentRepository.findAll(sort);
    }

    public List<Student> findAllByPage() {

        Pageable pageable = PageRequest.of(0,2);

        Page<Student> page = studentRepository.findAll(pageable);

        return page.getContent();
    }
}
