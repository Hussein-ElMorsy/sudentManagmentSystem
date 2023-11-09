package com.example.sudentmanagmentsystem;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(String ID);

    List<Student> getStudentsByGPA(double gpa);

    List<Student> getStudentsByFirstName(String firstName);

    Boolean addStudent(Student student);

    Boolean deleteStudent(String ID);
}

