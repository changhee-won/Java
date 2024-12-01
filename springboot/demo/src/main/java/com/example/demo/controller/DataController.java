// src/main/java/com/example/demo/controller/DataController.java
package com.example.demo.controller;

import com.example.demo.dto.Combined;
import com.example.demo.dto.Info;
import com.example.demo.dto.Master;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/all")
    public List<Combined> getAllData() {
        return dataService.getAllData();
    }

    @GetMapping("/infos")
    public List<Info> getAllInfo() {
        return dataService.getAllInfo();
    }

    @GetMapping("/masters")
    public List<Master> getAllMaster() {
        return dataService.getAllMaster();
    }


    @GetMapping("/data/{name}")
    public Combined getDataByName(@PathVariable String name) {
        return dataService.getDataByName(name);
    }

    @PutMapping("/data/{name}")
    public void updateData(@PathVariable String name, @RequestBody Combined combined) {
        dataService.updateData(name, combined);
    }

    @DeleteMapping("/data/{name}")
    public void deleteData(@PathVariable String name) {
        dataService.deleteData(name);
    }

    @PostMapping("/data")
    public void addData(@RequestBody Combined combined) {
        dataService.addData(combined);
    }
}
