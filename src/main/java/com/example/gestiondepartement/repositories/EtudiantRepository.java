package com.example.gestiondepartement.repositories;

import com.example.gestiondepartement.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
