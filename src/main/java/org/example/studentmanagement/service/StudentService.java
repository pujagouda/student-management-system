package org.example.studentmanagement.service;


import jakarta.validation.constraints.NotBlank;
import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.exception.StudentAlreadyExistsException;
import org.example.studentmanagement.exception.StudentNotFoundException;
import org.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
           throw new StudentAlreadyExistsException(
                   "Student with ID" +student.getId()+  "already exists"
           );
        }
        return studentRepository.save(student);
    }

    public Student getStudentbyID(int id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException(
                        "Student with Id " + id + " not found"
                ));
    }

    public Student updateStudent(int id, Student student) {
        Student existiingStudent = studentRepository.findById(id).orElse(null);
        if (existiingStudent != null) {

            existiingStudent.setName(student.getName());
            existiingStudent.setAge(student.getAge());
            existiingStudent.setCourse(student.getCourse());
            existiingStudent.setMarks(student.getMarks());

            return studentRepository.save(existiingStudent);
        }


        return null;


    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);

    }
//search name
    public List<Student>searchByName(String name){
        return studentRepository.findByNameContaining(name);
    }
    public Page<Student> searchByNameWithPagination(String name, Pageable pageable) {
        return studentRepository.findByNameContaining(name, pageable);
    }


    //sort marks in ascending & descending
    public List<Student>sortByMarksAsc(){
        return studentRepository.findByOrderByMarksAsc();
    }

    public List<Student>sortByMarksDesc(){
        return studentRepository.findByOrderByMarksDesc();
    }


    public Page<Student> getStudentsWithPagination(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}