package com.example.entity;

import lombok.Data;

/**
 * @ClassName : Person
 * @Description : 实体类
 * @Author : Mr.zh
 * @Date: 2020-08-13 20:28
 */
@Data
public class Person {

    private int id;

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
