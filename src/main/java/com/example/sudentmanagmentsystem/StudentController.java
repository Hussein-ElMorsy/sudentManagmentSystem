package com.example.sudentmanagmentsystem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getByID/{ID}")
    public Student getStudent(@PathVariable String ID) {
        return studentService.getStudentById(ID);
    }

    @GetMapping("/getByGPA/{gpa}")
    public List<Student> getStudentsByGPA(@PathVariable Double gpa) {
        //  double gpa_double = Double.parseDouble(gpa);
        return studentService.getStudentsByGPA(gpa);
    }

    @GetMapping("/getByFirstName/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    //    @PostMapping("/addStudent")
//    public String addStudent(@RequestBody Student student) {
//        return (studentService.addStudent(student)) ? "Added Successfully" : "Not added there is a student with this ID";
//    }
    @PostMapping("/addStudents")
    public ResponseEntity<String> addMultipleStudents(@RequestBody List<Student> students) {
        for (Student student : students) {
            studentService.addStudent(student);
        }
        String message = "Students have been successfully added.";
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{ID}")
    public String deleteStudent(@PathVariable String ID) {
        return studentService.deleteStudent(ID) ? "Deleted successfully" : "Student Not Found with this ID";

    }
}
