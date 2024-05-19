package com.example.gestiondepartement.controllers;
import com.example.gestiondepartement.models.Enseignant;
import com.example.gestiondepartement.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable("id") Long id) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        if (enseignant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(enseignant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Enseignant> createEnseignant(@RequestBody Enseignant enseignant) {
        Enseignant createdEnseignant = enseignantService.createEnseignant(enseignant);
        return new ResponseEntity<>(createdEnseignant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable("id") Long id, @RequestBody Enseignant enseignant) {
        Enseignant updatedEnseignant = enseignantService.updateEnseignant(id, enseignant);
        if (updatedEnseignant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedEnseignant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable("id") Long id) {
        enseignantService.deleteEnseignant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/taux-participation")
    public ResponseEntity<Double> getTauxParticipation(@PathVariable("id") Long id) {
        double taux = enseignantService.calculateTauxParticipation(id);
        return new ResponseEntity<>(taux, HttpStatus.OK);
    }
}
