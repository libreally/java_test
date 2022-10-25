package com.atguigu.spring.pojo;

import java.util.List;

public class Clazz {
    private Integer id;
    private String cname;
    private List<Student> students;

    public Clazz() {
    }

    public Clazz(Integer id, String cname) {
        this.id = id;
        this.cname = cname;
    }

    public Clazz(Integer id, String cname, List<Student> students) {
        this.id = id;
        this.cname = cname;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
