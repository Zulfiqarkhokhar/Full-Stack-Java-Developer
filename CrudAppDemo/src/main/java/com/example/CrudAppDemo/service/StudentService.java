package com.example.CrudAppDemo.service;

import com.example.CrudAppDemo.dto.StudentRequestDto;
import com.example.CrudAppDemo.dto.StudentResponseDto;
import com.example.CrudAppDemo.entity.Student;
import com.example.CrudAppDemo.exception.DuplicateResourceException;
import com.example.CrudAppDemo.exception.ResourceNotFoundException;
import com.example.CrudAppDemo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {

        Student student = mapToEntity(studentRequestDto);
        if(existEmail(student)){
            throw new DuplicateResourceException("Student with "+student.getEmail()+" already exist");
        }
        Student studentRes =  studentRepository.save(student);
       return mapToDto(studentRes);
    }

    public StudentResponseDto getStudent(Long id) {
        Student student =
                studentRepository
                        .findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found"));
        return mapToDto(student);
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findByDeletedIsFalse();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        for(Student student:students){
           studentResponseDtos.add(mapToDto(student));
        }
        return studentResponseDtos;
    }

    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));

        existingStudent.setName(studentRequestDto.getName());
        existingStudent.setEmail(studentRequestDto.getEmail());
        existingStudent.setAge(studentRequestDto.getAge());
        existingStudent.setRollNo(studentRequestDto.getRollNo());
        existingStudent.setSubject(studentRequestDto.getSubject());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(existingStudent);

        return mapToDto(updatedStudent);
    }


    public void deleteStudent(Long id) {
        Student studentToBeDelete = studentRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));
        studentRepository.delete(studentToBeDelete);

    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDelete = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));

        studentToBeDelete.setDeleted(true);
        studentRepository.save(studentToBeDelete);
    }


    private Student mapToEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setAge(studentRequestDto.getAge());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setSubject(studentRequestDto.getSubject());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private StudentResponseDto mapToDto(Student studentRes) {
        StudentResponseDto responseDto = new StudentResponseDto();

        responseDto.setId(studentRes.getId());
        responseDto.setName(studentRes.getName());
        responseDto.setEmail(studentRes.getEmail());
        responseDto.setAge(studentRes.getAge());
        responseDto.setRollNo(studentRes.getRollNo());
        responseDto.setSubject(studentRes.getSubject());
        responseDto.setMessage("Student Saved Successfully");
        responseDto.setCreatedAt(studentRes.getCreatedAt());
        responseDto.setUpdatedAt(studentRes.getUpdatedAt());

        return responseDto;
    }

    private Boolean existEmail(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }

}
