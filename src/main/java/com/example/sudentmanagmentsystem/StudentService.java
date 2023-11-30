package com.example.sudentmanagmentsystem;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents(String sortingField,String type);

    Student getStudentById(String ID);

    List<Student> getStudentsByGPA(Double gpa);

    List<Student> getStudentsByFirstName(String firstName);
    List<Student> getStudentsByLastName(String lastName);
    List<Student> getStudentsByAddress(String address);
    List<Student> getStudentsByGender(String gender);
    List<Student> getStudentsByLevel(Integer level);

    String  addStudent(Student student);

    Boolean deleteStudent(String ID);
    List<String> updateStudent(Student student,String ID);
}
