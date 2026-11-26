package com.example.SpringJPADemo.service;

import com.example.SpringJPADemo.entity.Department;
import com.example.SpringJPADemo.entity.Student;
import com.example.SpringJPADemo.repository.DepartmentRepository;
import com.example.SpringJPADemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId){
        Department department = departmentRepository.findById(deptId);

        student.setDepartment(department);

        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName){
       Department department = new Department();
       department.setName(deptName);

       departmentRepository.save(department);

        student.setDepartment(department);

        studentRepository.save(student);
    }
}
