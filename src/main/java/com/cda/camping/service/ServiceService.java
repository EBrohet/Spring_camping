package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.Services;
import com.cda.camping.repository.ServiceRepository;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public List<Services> getAllServices(){
        return serviceRepository.findAll();
    }

    public Services getService(Integer id){
        return serviceRepository.findById(id);
    }

    public void createService(Services service){
        serviceRepository.save(service);
    }

    public void updateService(Services service){
        serviceRepository.update(service);
    }

    public void deleteService(Integer id){
        serviceRepository.delete(id);
    }
}
