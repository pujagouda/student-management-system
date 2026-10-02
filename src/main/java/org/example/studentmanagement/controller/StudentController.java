package org.example.studentmanagement.controller;


import jakarta.validation.Valid;
import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")

    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentbyID(@PathVariable int id) {
        return studentService.getStudentbyID(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {

        studentService.deleteStudent(id);
    }

    @GetMapping("/students/search/{name}")
    public List<Student>searchByName(@PathVariable String name){
        return studentService.searchByName(name);

    }
    @GetMapping("/students/search-page")
    public Page<Student> searchWithPaginationAndSorting(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return studentService.searchByNameWithPagination(name, pageable);
    }


    @GetMapping("/students/sort/marks")
    public List<Student>sortByMarksAsc(){
        return studentService.sortByMarksAsc();

    }

    @GetMapping("/students/sort/marks/desc")
    public List<Student>sortByMarksDesc(){
        return studentService.sortByMarksDesc();

    }

    @GetMapping("/students/page")
    public Page<Student> getStudentsWithPagination(@RequestParam int page,
            @RequestParam int size) {

        Pageable pageable = PageRequest.of(page, size);

        return studentService.getStudentsWithPagination(pageable);
    }


    @GetMapping("/students/page-sort")
    public Page<Student> getStudentsWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return studentService.getStudentsWithPagination(pageable);
    }
}


