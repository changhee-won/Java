// src/main/java/com/example/demo/dto/Info.java
package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "info")
public class Info {
    @Id
    private String id;

    @Field("name") // MongoDB의 `name` 필드와 매핑
    private String name;
 
    @Field("job") // MongoDB의 `job` 필드와 매핑
    private String job;

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
