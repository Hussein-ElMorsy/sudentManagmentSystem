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
    public List<Student> getAllStudents(@PathVariable String sortingField, @PathVariable String type) {

        return studentService.getAllStudents(sortingField, type);
    }

    @GetMapping("/getByID/{ID}")
    public Student getStudent(@PathVariable String ID) {
        return studentService.getStudentById(ID);
    }

    @GetMapping("/getByGPA/{gpa}")
    public ResponseList getStudentsByGPA(@PathVariable Double gpa) {
        //  double gpa_double = Double.parseDouble(gpa);
        return studentService.getStudentsByGPA(gpa);
    }

    @GetMapping("/getByFirstName/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    @GetMapping("/getByLastName/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @GetMapping("/getByAddress/{address}")
    public List<Student> getStudentsByAddress(@PathVariable String address) {
        return studentService.getStudentsByAddress(address);
    }

    @GetMapping("/getByGender/{gender}")
    public List<Student> getStudentsByGender(@PathVariable String gender) {
        return studentService.getStudentsByGender(gender);
    }

    @GetMapping("/getByLevel/{level}")
    public List<Student> getStudentsByLevel(@PathVariable Integer level) {
        return studentService.getStudentsByLevel(level);
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
        return studentService.updateStudent(student, ID);

    }
}
