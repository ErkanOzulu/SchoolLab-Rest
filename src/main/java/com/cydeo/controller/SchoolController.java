package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
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
    public ResponseEntity<ResponseWrapper> readAllStudents(){

      return   ResponseEntity
              .ok(new ResponseWrapper("students are successfully retrieved.",studentService.findAll()));
    }

     /*
           create a parents endpoint where status code is 202
           additional header has "Parent" , "Returned"
           and following body structure
           "parents are successfully retrieved." message
           code:202
           success: true
           and parent data.
     */

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("parent","Returned")
                .body(new ResponseWrapper(true,"parents are successfully retrieved.", HttpStatus.ACCEPTED.value(), parentService.findAll()));
    }
}
