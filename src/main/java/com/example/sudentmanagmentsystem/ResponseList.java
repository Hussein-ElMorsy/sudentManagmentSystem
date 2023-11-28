package com.example.sudentmanagmentsystem;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "ResponseList")
public class ResponseList {
    List<Student> list;
    Integer size;
    public ResponseList(List<Student> list){
        this.list = list;
        this.size = list.size();
    }
}
