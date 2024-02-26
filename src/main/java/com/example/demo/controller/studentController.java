package com.example.demo.controller;
import com.example.demo.model.Student;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class studentController {
    Map<String,Student> mapIdtoStudent = new HashMap<>();
    Map<String,Student> mapUniversitytoStudent ;
    
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody String name,@RequestBody String adhar,@RequestBody int age,@RequestBody String university){
        String id = UUID.randomUUID().toString();
        Student student = new Student(id, name, age, adhar, university);
        mapIdtoStudent.put(id, student);
        mapUniversitytoStudent.put(id,student);
        return id;
    }
    @GetMapping("/getStudentsByUniversity/{university}")
    public List<Student> getStudentsByUniversity(@PathVariable String university) {
        return (List<Student>) mapUniversitytoStudent.put(university, null);
        
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return mapIdtoStudent.getOrDefault(id, null);
    }
}


