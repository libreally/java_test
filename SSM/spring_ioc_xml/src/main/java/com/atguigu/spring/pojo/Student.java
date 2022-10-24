package com.atguigu.spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student {
    private Integer id;
    private String name;
    private String gander;
    private Clazz clazz;
    private String[] habby;
    private Map<String,Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer id, String name, String gander) {
        this.id = id;
        this.name = name;
        this.gander = gander;
    }

    public Student(Integer id, String name, String gander, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.gander = gander;
        this.clazz = clazz;
    }

    public Student(Integer id, String name, String gander, Clazz clazz, String[] habby) {
        this.id = id;
        this.name = name;
        this.gander = gander;
        this.clazz = clazz;
        this.habby = habby;
    }

    public Student(Integer id, String name, String gander, Clazz clazz, String[] habby, Map<String, Teacher> teacherMap) {
        this.id = id;
        this.name = name;
        this.gander = gander;
        this.clazz = clazz;
        this.habby = habby;
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gander='" + gander + '\'' +
                ", clazz=" + clazz +
                ", habby=" + Arrays.toString(habby) +
                ", teacherMap=" + teacherMap +
                '}';
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String[] getHabby() {
        return habby;
    }

    public void setHabby(String[] habby) {
        this.habby = habby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }
}
