// src/main/java/com/example/demo/dto/Master.java
package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "master")
public class Master {
    @Id
    private String id;

    @Field("name") // MongoDB의 `name` 필드와 매핑
    private String name;

    @Field("age") // MongoDB의 `age` 필드와 매핑
    private int age;

    @Field("sex") // MongoDB의 `sex` 필드와 매핑
    private String sex;

    @Field("location") // MongoDB의 `location` 필드와 매핑
    private String location;
    
 // Getter 및 Setter
    public String getId() {
       return id;
    }   

    public void setId(String id) {
        this.id = id;
    }   
    // Getters and Setters
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
