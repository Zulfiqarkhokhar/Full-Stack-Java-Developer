package com.example.CrudAppDemo.repository;

import com.example.CrudAppDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
