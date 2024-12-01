
// src/main/java/com/example/demo/repository/InfoRepository.java
package com.example.demo.repository;

import com.example.demo.dto.Info;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends MongoRepository<Info, String> {
    Optional<Info> findByName(String name);
}