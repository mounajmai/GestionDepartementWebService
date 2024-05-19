package com.example.gestiondepartement.controllers;

import com.example.gestiondepartement.models.Etudiant;
import com.example.gestiondepartement.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
        return new ResponseEntity<>(createdEtudiant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiant);
        if (updatedEtudiant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/taux-absenteisme")
    public ResponseEntity<Double> getTauxAbsenteisme(@PathVariable("id") Long id) {
        double taux = etudiantService.calculateTauxAbsenteisme(id);
        return new ResponseEntity<>(taux, HttpStatus.OK);
    }

    @GetMapping("/{id}/taux-reussite")
    public ResponseEntity<Double> getTauxReussite(@PathVariable("id") Long id) {
        double taux = etudiantService.calculateTauxReussite(id);
        return new ResponseEntity<>(taux, HttpStatus.OK);
    }
}
