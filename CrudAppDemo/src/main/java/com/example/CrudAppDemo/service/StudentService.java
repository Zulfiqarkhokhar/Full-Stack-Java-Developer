package com.example.CrudAppDemo.service;

import com.example.CrudAppDemo.entity.Student;
import com.example.CrudAppDemo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        student.setDeleted(false);
       Student studentRes =  studentRepository.save(student);
       return studentRes;
    }

    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeletedIsFalse(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findByDeletedIsFalse();
        return students;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToUpdate = existingStudent.get();
        studentToUpdate.setName(student.getName());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setAge(student.getAge());
        studentToUpdate.setRollNo(student.getRollNo());
        studentToUpdate.setSubject(student.getSubject());
        studentToUpdate.setDeleted(false);

        return studentRepository.save(studentToUpdate);
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
}
