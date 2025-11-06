package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.FacturesService;
import com.cda.camping.repository.FacturesServiceRepository;

@Service
public class FacturesServiceService {
    
    @Autowired
    private FacturesServiceRepository facturesServiceRepository;

    public List<FacturesService> getAllFacturesServices(){
        return facturesServiceRepository.findAll();
    }

    public FacturesService getFacturesService(Integer id){
        return facturesServiceRepository.findById(id);
    }

    public void createFacturesService(FacturesService facturesService){
        facturesServiceRepository.save(facturesService);
    }

    public void updateFacturesService(FacturesService facturesService){
        facturesServiceRepository.update(facturesService);
    }

    public void deleteFacturesService(Integer id){
        facturesServiceRepository.delete(id);
    }
}
