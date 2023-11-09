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
    public List<Student> getStudentsByGPA(double gpa) {
        List<Student> foundStud = new ArrayList<>();
        for (Student stud : students) {
            if (stud.getGpa() == gpa)
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
    public Boolean addStudent(Student student) {

        for (Student stud : students) {
            if (stud.getId().equals(student.getId())) {
                return false;
            }

        }
        if (students.add(student)) {
            saveToXML();
            System.out.println(students);
            return true;
        }
        return false;
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
