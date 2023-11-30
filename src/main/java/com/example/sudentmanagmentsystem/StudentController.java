package com.example.sudentmanagmentsystem;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:63342")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll/{sortingField}/{type}")
    public List<Student> getAllStudents(@PathVariable String sortingField,@PathVariable String type) {
        return studentService.getAllStudents(sortingField,type);
    }

    @GetMapping("/getByID/{ID}")
    public Student getStudent(@PathVariable String ID) {
        return studentService.getStudentById(ID);
    }

    @GetMapping("/getByGPA/{gpa}")
    public ResponseList getStudentsByGPA(@PathVariable Double gpa) {
        //  double gpa_double = Double.parseDouble(gpa);
        List<Student> students = studentService.getStudentsByGPA(gpa);
        ResponseList response = new ResponseList(students);
        return response;
    }

    @GetMapping("/getByFirstName/{firstName}")
    public ResponseList getStudentsByFirstName(@PathVariable String firstName) {
        List<Student> students = studentService.getStudentsByFirstName(firstName);
        ResponseList response = new ResponseList(students);
        return response;
    }
    @GetMapping("/getByLastName/{lastName}")
    public ResponseList getStudentsByLastName(@PathVariable String lastName) {
        List<Student> students = studentService.getStudentsByLastName(lastName);
        ResponseList response = new ResponseList(students);
        return response;
    }
    @GetMapping("/getByAddress/{address}")
    public ResponseList getStudentsByAddress(@PathVariable String address) {
        List<Student> students = studentService.getStudentsByAddress(address);
        ResponseList response = new ResponseList(students);
        return response;
    }

    @GetMapping("/getByGender/{gender}")
    public ResponseList getStudentsByGender(@PathVariable String gender) {
        List<Student> students = studentService.getStudentsByGender(gender);
        ResponseList response = new ResponseList(students);
        return response;
    }

    @GetMapping("/getByLevel/{level}")
    public ResponseList getStudentsByLevel(@PathVariable Integer level) {
        List<Student> students = studentService.getStudentsByLevel(level);
        ResponseList response = new ResponseList(students);
        return response;
    }
    @PostMapping("/addStudents")
    public ResponseEntity<List<String>> addMultipleStudents(@RequestBody List<Student> students) {
        List<String> message = new ArrayList<>();
        int idx = 1;
        for (Student student : students) {
            String msg = "Student#";
            msg += (idx++) + ". ";
            msg += studentService.addStudent(student);
            message.add(msg);
        }

        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{ID}")
    public String deleteStudent(@PathVariable String ID) {
        return studentService.deleteStudent(ID) ? "Deleted successfully" : "Student Not Found with this ID";

    }

    @PatchMapping("/{ID}")
    public List<String> updateStudent(@RequestBody Student student, @PathVariable String ID) {
        return studentService.updateStudent(student,ID) ;

    }


}