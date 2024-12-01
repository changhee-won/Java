// src/main/java/com/example/demo/repository/MasterRepository.java
package com.example.demo.repository;

import com.example.demo.dto.Master;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends MongoRepository<Master, String> {
    Optional<Master> findByName(String name);
}