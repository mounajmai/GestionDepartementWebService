package com.example.gestiondepartement.services;

import com.example.gestiondepartement.models.Enseignant;
import com.example.gestiondepartement.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    public Enseignant createEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public Enseignant updateEnseignant(Long id, Enseignant updatedEnseignant) {
        if (enseignantRepository.existsById(id)) {
            updatedEnseignant.setId(id);
            return enseignantRepository.save(updatedEnseignant);
        }
        return null;
    }

    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    public double calculateTauxParticipation(Long id) {
        Enseignant enseignant = getEnseignantById(id);
        if (enseignant != null && enseignant.getCoursPrevus() > 0) {
            return (double) enseignant.getCoursRealises() / enseignant.getCoursPrevus() * 100;
        }
        return 0;
    }
}
