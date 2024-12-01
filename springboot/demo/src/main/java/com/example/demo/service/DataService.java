// src/main/java/com/example/demo/service/DataService.java
package com.example.demo.service;

import com.example.demo.dto.Combined;
import com.example.demo.dto.Info;
import com.example.demo.dto.Master;
import com.example.demo.repository.InfoRepository;
import com.example.demo.repository.MasterRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataService {

   
    private MasterRepository masterRepository;

    
    private InfoRepository infoRepository;

    public List<Combined> getAllData() {
        List<Master> masters = masterRepository.findAll();
        List<Info> infos = infoRepository.findAll();

        return masters.stream().map(master -> {
            Combined combined = new Combined();
            combined.setName(master.getName());
            combined.setAge(master.getAge());
            combined.setSex(master.getSex());
            combined.setLocation(master.getLocation());

            infos.stream()
                    .filter(info -> info.getName().equals(master.getName()))
                    .findFirst()
                    .ifPresent(info -> combined.setJob(info.getJob()));

            return combined;
        }).collect(Collectors.toList());
    }

    public Combined getDataByName(String name) {
        Optional<Master> masterOpt = masterRepository.findById(name);
        Optional<Info> infoOpt = infoRepository.findById(name);

        if (masterOpt.isPresent() && infoOpt.isPresent()) {
            Master master = masterOpt.get();
            Info info = infoOpt.get();

            Combined combined = new Combined();
            combined.setName(master.getName());
            combined.setAge(master.getAge());
            combined.setSex(master.getSex());
            combined.setLocation(master.getLocation());
            combined.setJob(info.getJob());

            return combined;
        }

        return null;
    }

    public void updateData(String name, Combined combined) {
        Optional<Master> masterOpt = masterRepository.findById(name);
        Optional<Info> infoOpt = infoRepository.findById(name);

        if (masterOpt.isPresent() && infoOpt.isPresent()) {
            Master master = masterOpt.get();
            Info info = infoOpt.get();

            master.setAge(combined.getAge());
            master.setSex(combined.getSex());
            master.setLocation(combined.getLocation());
            masterRepository.save(master);

            info.setJob(combined.getJob());
            infoRepository.save(info);
        }
    }

    public void deleteData(String name) {
        masterRepository.deleteById(name);
        infoRepository.deleteById(name);
    }

    public void addData(Combined combined) {
        Master master = new Master();
        master.setName(combined.getName());
        master.setAge(combined.getAge());
        master.setSex(combined.getSex());
        master.setLocation(combined.getLocation());
        masterRepository.save(master);

        Info info = new Info();
        info.setName(combined.getName());
        info.setJob(combined.getJob());
        infoRepository.save(info);
    }

    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }
    public List<Master> getAllMaster() {
        return masterRepository.findAll();
    }
}
