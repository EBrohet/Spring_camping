package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Hebergement;
import com.cda.camping.repository.HebergementRepository;


@Service
public class HebergementService {
    
    @Autowired
    private HebergementRepository hebergementRepository;

    public List<Hebergement> getAllHebergements(){
        return hebergementRepository.findAll();
    }

    public Hebergement getHebergement(Integer id){
        return hebergementRepository.findById(id);
    }

    public void createHebergement(Hebergement hebergement){
        hebergementRepository.save(hebergement);
    }

    public void updateHebergement(Hebergement hebergement){
        hebergementRepository.update(hebergement);
    }

    public void deleteHebergement(Integer id){
        hebergementRepository.delete(id);
    }
}
