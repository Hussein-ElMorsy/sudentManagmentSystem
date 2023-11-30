package com.example.sudentmanagmentsystem;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
public class Student {
    public String id;
    public String firstName;
    public String lastName;
    public String gender;
    public Double gpa;
    public Integer level;
    public String address;

    @XmlAttribute(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FirstName: " + this.firstName + ", LastName: " + this.lastName +
                ", Gender: " + this.gender +
                ", Level: " + this.level +
                ", GPA:" + this.gpa +
                ", Address: " + this.address +
                ", ID: " + this.id;
    }

}