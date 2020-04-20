package com.example.memory;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

/**
 * Created by chengjie on 2020-03-28
 * Description:
 */
public class Student {
    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student("aa",33);
        student.name = "lisi";
        student.age = 24;
        String json = new Gson().toJson(student);
        String fast = JSON.toJSONString(student);
        System.out.println(json);
        System.out.println(fast);

    }
}
