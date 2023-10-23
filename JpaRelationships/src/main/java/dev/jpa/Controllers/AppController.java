package dev.jpa.Controllers;

import dev.jpa.Models.Course;
import dev.jpa.Models.Student;
import dev.jpa.Services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("")
    public ResponseEntity<String> greetings(){
        return new ResponseEntity<>("Ola", HttpStatus.OK);
    }

    @GetMapping("/list/students")
    public ResponseEntity<List<Student>> listStudentes(){
        return new ResponseEntity<>(appService.getListStudents(), HttpStatus.OK);
    }
    @GetMapping("/list/courses")
    public ResponseEntity<List<Course>> listCourses(){
        return new ResponseEntity<>(appService.getListCourses(), HttpStatus.OK);
    }

    @GetMapping("/list/students/{studentId}")
    public ResponseEntity<Optional<Student>> listCourses(@PathVariable Long studentId ){
        return new ResponseEntity<>(appService.getStudent(studentId), HttpStatus.OK);
    }

    @PostMapping("/list/students/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(appService.addStudent(student), HttpStatus.OK);
    }

}
