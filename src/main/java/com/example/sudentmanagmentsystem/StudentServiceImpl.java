package com.example.sudentmanagmentsystem;

import org.springframework.stereotype.Service;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private List<Student> students;
    private File xmlFile;

    public StudentServiceImpl() {
        // Initialize the list of students and xmlFile from the XML file (if it exists)
        // if the XML file doesn't exist, create an empty list

        xmlFile = new File("Students.xml");
        if (xmlFile.exists()) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
                University university = (University) jaxbContext.createUnmarshaller().unmarshal(xmlFile);
                students = university.getStudents();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            students = new ArrayList<>();
        }
        if (students == null) {
            students = new ArrayList<>();
        }

    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(String ID) {
        for (Student stud : students) {
            if (stud.getId().equals(ID))
                return stud;
        }
        return null;
    }

    @Override
    public ResponseList getStudentsByGPA(Double gpa) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getGpa().equals(gpa))
                foundStud.add(stud);
        }
        return new ResponseList(foundStud);
    }

    @Override
    public List<Student> getStudentsByFirstName(String firstName) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getFirstName().equals(firstName))
                foundStud.add(stud);
        }
        return foundStud;
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getLastName().equals(lastName))
                foundStud.add(stud);
        }
        return foundStud;
    }
    @Override
    public List<Student> getStudentsByAddress(String address) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getAddress().equals(address))
                foundStud.add(stud);
        }
        return foundStud;
    }
    @Override
    public List<Student> getStudentsByGender(String gender) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getGender().equals(gender))
                foundStud.add(stud);
        }
        return foundStud;
    }
    @Override
    public List<Student> getStudentsByLevel(Integer level) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getLevel()==level)
                foundStud.add(stud);
        }
        return foundStud;
    }

    @Override
    public String addStudent(Student student) {
        if (student.getId() == null ||
                student.getFirstName() == null ||
                student.getLastName() == null ||
                student.getGpa() == null ||
                student.getAddress() == null ||
                student.getGender() == null ||
                student.getLevel() == null
        ) {
            return "Cannot add student with any empty fields.";
        }
        if (student.getGpa() < 0.0 || student.getGpa() > 4.0) {
            return "GPA should be between (0.0-4.0)";
        }

        if (student.getLevel() < 0) {
            return "Level cannot be negative.";
        }

        String pattern = "^[a-zA-Z]+$";
        if (!(student.getAddress().matches(pattern) && student.getFirstName().matches(pattern) && student.getLastName().matches(pattern))) {
            return "Address, FirstName and LastName should be alphabetic.";
        }

        for (Student stud : students) {
            if (stud.getId().equals(student.getId())) {
                return "Cannot Add student with duplicated ID.";
            }
        }
        if (students.add(student)) {
            saveToXML();
            System.out.println(students);
            return "Added successfully.";
        }
        return "Something went wrong!";
    }

    @Override
    public Boolean deleteStudent(String ID) {
        // Implement the logic to delete a student by ID
        for (Student stud : students) {
            if (stud.getId().equals(ID)) {
                students.remove(stud);
                saveToXML();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> updateStudent(Student student, String ID) {
//        Integer ok = 1;
//        if (student.getId() != null) {
//            return "updating ID is not valid.";
//        }
//        if (student.getGpa() != null && (student.getGpa() < 0.0 || student.getGpa() > 4.0)) {
//            return "GPA should be between (0.0-4.0)";
//        }
//
//        if (student.getLevel() != null && student.getLevel() < 0) {
//            return "Level cannot be negative.";
//        }
        List<String> message = new ArrayList<>();
        String pattern = "^[a-zA-Z]+$";
//        if ((student.getAddress() != null || student.getFirstName() != null || student.getLastName() != null) &&
//                (!(student.getAddress().matches(pattern) && student.getFirstName().matches(pattern) && student.getLastName().matches(pattern)))) {
//            return "Address, FirstName and LastName should be alphabetic.";
//        }
//        if (student.getAddress() != null && !student.getAddress().matches(pattern))
//            return "Address should be alphabetic.";
//        if (student.getLastName() != null && !student.getLastName().matches(pattern))
//            return "Last Name should be alphabetic.";
//        if (student.getFirstName() != null && !student.getFirstName().matches(pattern))
//            return "First Name should be alphabetic.";


        for (Student stud : students) {
            if (stud.getId().equals(ID)) {
                if(student.getGpa()!=null){
                    if(student.getGpa()<0.0 || student.getGpa()>4.0){
                        message.add( "GPA should be between (0.0-4.0)");
                    }else{
                        stud.setGpa(student.getGpa());
                        message.add("GPA Updated successfully");
                    }
                }
                if(student.getLevel()!=null){
                    if(student.getLevel() < 0){
                        message.add("Level cannot be negative.");
                    }else{
                        stud.setLevel(student.getLevel());
                        message.add("Level Updated successfully");
                    }
                }
                if(student.getGender()!=null){
                    stud.setGender(student.getGender());
                    message.add("Gender Updated successfully");
                }
                if(student.getLastName()!=null){
                    if(!student.getLastName().matches(pattern)){
                        message.add("Last Name should be alphabetic.");
                    }else{
                     stud.setLastName(student.getLastName());
                     message.add("Last Name updated successfully");
                    }
                }
                if(student.getFirstName()!=null){
                    if(!student.getFirstName().matches(pattern)){
                        message.add("First Name should be alphabetic.");
                    }else{
                        stud.setFirstName(student.getFirstName());
                        message.add("First Name Updated successfully.");
                    }

                }
                if(student.getAddress()!=null){
                    if(!student.getAddress().matches(pattern)){
                        message.add("address should be alphabetic.");
                    }else{
                        stud.setAddress(student.getAddress());
                        message.add("address uodated successfully.");
                    }

                }
                saveToXML();

            }
        }
        return message;
    }

    private void saveToXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            University university = new University();
            university.setStudents(students);
            marshaller.marshal(university, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
