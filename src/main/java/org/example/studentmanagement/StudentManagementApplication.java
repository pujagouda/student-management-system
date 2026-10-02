package org.example.studentmanagement;

import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.repository.StudentRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {

       ConfigurableApplicationContext context =
               SpringApplication.run(StudentManagementApplication.class, args);


       StudentRepository studentRepository= context.getBean(StudentRepository.class);

        Student std=new Student();

        std.setId(108);
        std.setName("");
        std.setAge(13);
        std.setCourse("");
        std.setMarks(720.9);

        studentRepository.save(std);

        System.out.println("save successful");
    }

}
