package com.example.sudentmanagmentsystem;

import org.springframework.stereotype.Service;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
    public List<Student> getAllStudents(String sortingField,String type) {
        if(sortingField.equals("id")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                   if(type.equals("asc")){
                       if(students.get(i).getId().compareTo(students.get(j).getId()) > 0){
                           Collections.swap(students,i,j);
                       }
                   }else{
                       if(students.get(i).getId().compareTo(students.get(j).getId()) < 0){
                           Collections.swap(students,i,j);
                       }
                   }
                }
            }
        }
        if(sortingField.equals("lastName")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                    if(type.equals("asc")){
                        if(students.get(i).getLastName().compareTo(students.get(j).getLastName()) > 0){
                            Collections.swap(students,i,j);
                        }
                    }else{
                        if(students.get(i).getLastName().compareTo(students.get(j).getLastName()) < 0){
                            Collections.swap(students,i,j);
                        }
                    }
                }
            }
        }
        if(sortingField.equals("firstName")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                    if(type.equals("asc")){
                        if(students.get(i).getFirstName().compareTo(students.get(j).getFirstName()) > 0){
                            Collections.swap(students,i,j);
                        }
                    }else{
                        if(students.get(i).getFirstName().compareTo(students.get(j).getFirstName()) < 0){
                            Collections.swap(students,i,j);
                        }
                    }
                }
            }
        }
        if(sortingField.equals("address")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                    if(type.equals("asc")){
                        if(students.get(i).getAddress().compareTo(students.get(j).getAddress()) > 0){
                            Collections.swap(students,i,j);
                        }
                    }else{
                        if(students.get(i).getAddress().compareTo(students.get(j).getAddress()) < 0){
                            Collections.swap(students,i,j);
                        }
                    }
                }
            }
        }
        if(sortingField.equals("gender")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                    if(type.equals("asc")){
                        if(students.get(i).getGender().compareTo(students.get(j).getGender()) > 0){
                            Collections.swap(students,i,j);
                        }
                    }else{
                        if(students.get(i).getGender().compareTo(students.get(j).getGender()) < 0){
                            Collections.swap(students,i,j);
                        }
                    }
                }
            }
        }

        if(sortingField.equals("gpa")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                    if(type.equals("asc")){
                        if(students.get(i).getGpa() > students.get(j).getGpa()){
                            Collections.swap(students,i,j);
                        }
                    }else{
                        if(students.get(i).getGpa() < students.get(j).getGpa()){
                            Collections.swap(students,i,j);
                        }
                    }
                }
            }
        }
        if(sortingField.equals("level")){
            for (int i = 0; i < students.size(); i++) {
                for (int j = i+1;j<students.size();j++){
                    if(type.equals("asc")){
                        if(students.get(i).getLevel() > students.get(j).getLevel()){
                            Collections.swap(students,i,j);
                        }
                    }else{
                        if(students.get(i).getLevel() < students.get(j).getLevel()){
                            Collections.swap(students,i,j);
                        }
                    }
                }
            }
        }


        saveToXML();
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
    public List<Student> getStudentsByGPA(Double gpa) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getGpa().equals(gpa))
                foundStud.add(stud);
        }
        return foundStud;
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

        student.setGender(student.getGender().toLowerCase());
        student.setFirstName(student.getFirstName().toLowerCase());
        student.setLastName(student.getLastName().toLowerCase());
        student.setAddress(student.getAddress().toLowerCase());
        System.out.println(student.getFirstName());
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
        Integer ok = 1;
        List<String> message = new ArrayList<>();
        String pattern = "^[a-zA-Z]+$";

        if (student.getId() != null) {
            ok = 0;
            message.add("Updating ID is not valid.");
        }
        for (Student stud : students) {
            if (stud.getId().equals(ID)) {
                if (student.getGpa() != null) {
                    if (student.getGpa() < 0.0 || student.getGpa() > 4.0) {
                        ok = 0;
                        message.add("GPA should be between (0.0-4.0)");
                    } else if (ok == 1) {
                        stud.setGpa(student.getGpa());
                    }
                }
                if (student.getLevel() != null) {
                    if (student.getLevel() < 0) {
                        ok = 0;
                        message.add("Level cannot be negative.");
                    } else if (ok == 1) {
                        stud.setLevel(student.getLevel());
                    }
                }
                if (student.getGender() != null) {
                    if (ok == 1) {
                        stud.setGender(student.getGender().toLowerCase());
                    }
                }
                if (student.getLastName() != null) {
                    if (!student.getLastName().matches(pattern)) {
                        ok = 0;
                        message.add("Last Name should be alphabetic.");
                    } else if (ok == 1) {
                        stud.setLastName(student.getLastName().toLowerCase());
                    }
                }
                if (student.getFirstName() != null) {
                    if (!student.getFirstName().matches(pattern)) {
                        ok = 0;
                        message.add("First Name should be alphabetic.");
                    } else if (ok == 1) {
                        stud.setFirstName(student.getFirstName().toLowerCase());
                    }
                }
                if (student.getAddress() != null) {
                    if (!student.getAddress().matches(pattern)) {
                        ok = 0;
                        message.add("Address should be alphabetic.");
                    } else if (ok == 1) {
                        stud.setAddress(student.getAddress().toLowerCase());
                    }
                }
                if (ok == 1) {
                    message.add("Updated successfully.");
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