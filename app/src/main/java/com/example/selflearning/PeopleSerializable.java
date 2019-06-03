package com.example.selflearning;

import java.io.Serializable;

public class PeopleSerializable implements Serializable {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public PeopleSerializable(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
