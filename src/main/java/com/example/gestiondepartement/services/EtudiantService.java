package com.example.gestiondepartement.services;

import com.example.gestiondepartement.models.Etudiant;
import com.example.gestiondepartement.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant) {
        if (etudiantRepository.existsById(id)) {
            updatedEtudiant.setId(id);
            return etudiantRepository.save(updatedEtudiant);
        }
        return null;
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public double calculateTauxAbsenteisme(Long id) {
        Etudiant etudiant = getEtudiantById(id);
        if (etudiant != null) {
            int total = etudiant.getAbsences() + etudiant.getPresences();
            if (total > 0) {
                return (double) etudiant.getAbsences() / total * 100;
            }
        }
        return 0;
    }

    public double calculateTauxReussite(Long id) {
        Etudiant etudiant = getEtudiantById(id);
        if (etudiant != null && etudiant.getNotes() != null && !etudiant.getNotes().isEmpty()) {
            OptionalDouble average = etudiant.getNotes().stream().mapToDouble(Double::doubleValue).average();
            if (average.isPresent()) {
                return average.getAsDouble();
            }
        }
        return 0;
    }
}
