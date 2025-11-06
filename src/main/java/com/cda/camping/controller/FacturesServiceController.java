package com.cda.camping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.camping.model.FacturesService;
import com.cda.camping.service.FacturesServiceService;

@Controller
@RestController
@RequestMapping("/api/factures_services")
public class FacturesServiceController {
    @Autowired
    private FacturesServiceService facturesServiceService;

    @GetMapping
    public ResponseEntity<List<FacturesService>> getAllFacturesServices(){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(facturesServiceService.getAllFacturesServices(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturesService> getFacturesServiceById(@PathVariable("id") Integer id){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(facturesServiceService.getFacturesService(id), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @PostMapping
    public ResponseEntity<String> createFacturesService(@RequestBody FacturesService facturesService){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            facturesServiceService.createFacturesService(facturesService);
            return new ResponseEntity<>("{message : 'Service facture ajouté'}", headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @PutMapping
    public ResponseEntity<String> updateFacturesService(@RequestBody FacturesService facturesService){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            facturesServiceService.updateFacturesService(facturesService);
            return new ResponseEntity<>("{message : 'Service facture modifié'}", headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacturesService(@PathVariable("id") Integer id){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            facturesServiceService.deleteFacturesService(id);
            return new ResponseEntity<>("{message : 'SErvice facture supprimé'}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
