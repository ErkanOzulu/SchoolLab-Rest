package com.cydeo.controller;

import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.StudentWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;

    public SchoolController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        return teacherService.findAll();
    }

     /*
        create an endpoint for students, where json response includes
        "students are successfully retrieved." message
        code:200
        success:true
        and student data
     */

    @GetMapping("students")
    public ResponseEntity<StudentWrapper> allStudents(){

      return   ResponseEntity
              .ok(new StudentWrapper("students are successfully retrieved.",studentService.findAll()));
    }
}
