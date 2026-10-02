package org.example.studentmanagement.repository;

import org.example.studentmanagement.entity.Student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

public  interface StudentRepository extends JpaRepository<Student,Integer>{

    //find the name
    List<Student>findByNameContaining(String name);

    //find name with pagination and sorting
    Page<Student> findByNameContaining(String name, Pageable pageable);

   //sort marks in ascending
    List<Student> findByOrderByMarksAsc();
    //sort marks in descending
    List<Student> findByOrderByMarksDesc();



    }

