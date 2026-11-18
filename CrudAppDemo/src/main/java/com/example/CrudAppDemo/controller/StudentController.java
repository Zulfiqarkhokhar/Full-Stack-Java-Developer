package com.example.CrudAppDemo.controller;

import com.example.CrudAppDemo.dto.StudentRequestDto;
import com.example.CrudAppDemo.dto.StudentResponseDto;
import com.example.CrudAppDemo.entity.Student;
import com.example.CrudAppDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto studentRes = studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long id){
        StudentResponseDto studentResponseDto = studentService.getStudent(id);
        if(studentResponseDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        List<StudentResponseDto> studentResponseDtos = studentService.getAllStudents();
        if(studentResponseDtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long id,@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto updatedStudent = studentService.updateStudent(id,studentRequestDto);
        if(updatedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean deleted = studentService.deleteStudent(id);
        if(!deleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        return ResponseEntity.ok("Record Deleted");
    }

    //soft delete
    @PatchMapping("/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
        Boolean deleted = studentService.deleteStudentSoftly(id);
        if(!deleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        return ResponseEntity.ok("Record Deleted");
    }
}
