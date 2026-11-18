package com.example.CrudAppDemo.service;

import com.example.CrudAppDemo.dto.StudentRequestDto;
import com.example.CrudAppDemo.dto.StudentResponseDto;
import com.example.CrudAppDemo.entity.Student;
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
        Student studentRes =  studentRepository.save(student);
       return mapToDto(studentRes);
    }

    public StudentResponseDto getStudent(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeletedIsFalse(id);
        if(student.isPresent()){
            StudentResponseDto studentResponseDto = mapToDto(student.get());
            return studentResponseDto;
        }
        return null;
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
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToUpdate = existingStudent.get();
        studentToUpdate.setName(studentRequestDto.getName());
        studentToUpdate.setEmail(studentRequestDto.getEmail());
        studentToUpdate.setAge(studentRequestDto.getAge());
        studentToUpdate.setRollNo(studentRequestDto.getRollNo());
        studentToUpdate.setSubject(studentRequestDto.getSubject());
        studentToUpdate.setDeleted(false);
        studentToUpdate.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(studentToUpdate);

        return mapToDto(updatedStudent);
    }


    public Boolean deleteStudent(Long id) {
        Boolean isPresent = studentRepository.existsById(id);
        if(!isPresent){
            return false;
        }
        studentRepository.deleteById(id);
        return true;

    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
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

}
