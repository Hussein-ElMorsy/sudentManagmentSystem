package com.example.sudentmanagmentsystem;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "ResponseList")
public class ResponseList {
    List<Student> list;
    Integer size;

    public ResponseList(List<Student> list) {
        this.list = list;
        this.size = list.size();
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
