package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Type;
import com.cda.camping.repository.TypeRepository;

@Service
public class TypeService {
    
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllTypes(){
        return typeRepository.findAll();
    }

    public Type getType(Integer id){
        return typeRepository.findById(id);
    }

    public void createType(Type type){
        typeRepository.save(type);
    }

    public void updateType(Type type){
        typeRepository.update(type);
    }

    public void deleteType(Integer id){
        typeRepository.delete(id);
    }
}
