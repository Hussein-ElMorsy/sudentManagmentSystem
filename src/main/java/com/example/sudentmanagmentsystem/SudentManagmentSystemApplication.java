package com.example.sudentmanagmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudentManagmentSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(SudentManagmentSystemApplication.class, args);
        StudentServiceImpl studentService = new StudentServiceImpl();

//        Student student = new Student();
//        student.setAddress("address");
//        student.setFirstName("firstname");
//        student.setLastName("lastname");
//        student.setGender("gender");
//        student.setId("20200");
//        student.setGpa(3.21);
//        student.setLevel(4);
//        System.out.println(studentService.getAllStudents());
//        if (studentService.addStudent(student)) {
//            System.out.println(student.toString() + "added successfully");
//        } else {
//            System.out.println("Student found with same ID XD");
//        }
//        System.out.println(studentService.getStudentsByGPA(3.21).toString());
//        System.out.println(studentService.getStudentsByFirstName("firstname").toString());
//        if (studentService.deleteStudent("202001")) {
//            System.out.println("Deleted successfully");
//        } else {
//            System.out.println("There is no student with this ID");
//        }
//        if (studentService.deleteStudent("20200")) {
//            System.out.println("Deleted successfully");
//        } else {
//            System.out.println("There is no student with this ID");
//        }
    }

}
