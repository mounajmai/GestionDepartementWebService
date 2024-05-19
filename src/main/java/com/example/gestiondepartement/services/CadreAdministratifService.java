package com.example.gestiondepartement.services;
import com.example.gestiondepartement.models.CadreAdministratif;
import com.example.gestiondepartement.repositories.CadreAdministratifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CadreAdministratifService {

    @Autowired
    private CadreAdministratifRepository cadreAdministratifRepository;

    public List<CadreAdministratif> getAllCadresAdministratifs() {
        return cadreAdministratifRepository.findAll();
    }

    public CadreAdministratif getCadreAdministratifById(Long id) {
        return cadreAdministratifRepository.findById(id).orElse(null);
    }

    public CadreAdministratif createCadreAdministratif(CadreAdministratif cadreAdministratif) {
        return cadreAdministratifRepository.save(cadreAdministratif);
    }

    public CadreAdministratif updateCadreAdministratif(Long id, CadreAdministratif updatedCadreAdministratif) {
        if (cadreAdministratifRepository.existsById(id)) {
            updatedCadreAdministratif.setId(id);
            return cadreAdministratifRepository.save(updatedCadreAdministratif);
        }
        return null;
    }

    public void deleteCadreAdministratif(Long id) {
        cadreAdministratifRepository.deleteById(id);
    }

    public double calculerTauxAbsentéisme() {
        List<CadreAdministratif> cadresAdministratifs = cadreAdministratifRepository.findAll();
        if (cadresAdministratifs.isEmpty()) {
            return 0.0;
        }

        int totalJoursTravailPrevus = cadresAdministratifs.stream()
                .mapToInt(CadreAdministratif::getJoursTravailPrevus)
                .sum();

        int totalJoursAbsencePrevus = cadresAdministratifs.stream()
                .mapToInt(CadreAdministratif::getJoursAbsencePrevus)
                .sum();

        return (double) totalJoursAbsencePrevus / totalJoursTravailPrevus * 100.0;
    }
}
