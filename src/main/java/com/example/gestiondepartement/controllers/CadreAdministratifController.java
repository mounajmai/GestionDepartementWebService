package com.example.gestiondepartement.controllers;



import com.example.gestiondepartement.models.CadreAdministratif;
import com.example.gestiondepartement.services.CadreAdministratifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cadres-administratifs")
public class CadreAdministratifController {

    @Autowired
    private CadreAdministratifService cadreAdministratifService;

    @GetMapping
    public ResponseEntity<List<CadreAdministratif>> getAllCadresAdministratifs() {
        List<CadreAdministratif> cadresAdministratifs = cadreAdministratifService.getAllCadresAdministratifs();
        return new ResponseEntity<>(cadresAdministratifs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadreAdministratif> getCadreAdministratifById(@PathVariable("id") Long id) {
        CadreAdministratif cadreAdministratif = cadreAdministratifService.getCadreAdministratifById(id);
        if (cadreAdministratif == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cadreAdministratif, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CadreAdministratif> createCadreAdministratif(@RequestBody CadreAdministratif cadreAdministratif) {
        CadreAdministratif createdCadreAdministratif = cadreAdministratifService.createCadreAdministratif(cadreAdministratif);
        return new ResponseEntity<>(createdCadreAdministratif, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadreAdministratif> updateCadreAdministratif(@PathVariable("id") Long id, @RequestBody CadreAdministratif cadreAdministratif) {
        CadreAdministratif updatedCadreAdministratif = cadreAdministratifService.updateCadreAdministratif(id, cadreAdministratif);
        if (updatedCadreAdministratif == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCadreAdministratif, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadreAdministratif(@PathVariable("id") Long id) {
        cadreAdministratifService.deleteCadreAdministratif(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/taux-absenteisme")
    public ResponseEntity<Double> getTauxAbsenteisme() {
        double tauxAbsenteisme = cadreAdministratifService.calculerTauxAbsentéisme();
        return new ResponseEntity<>(tauxAbsenteisme, HttpStatus.OK);
    }
}

