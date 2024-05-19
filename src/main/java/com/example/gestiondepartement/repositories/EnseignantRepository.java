package com.example.gestiondepartement.repositories;


import com.example.gestiondepartement.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}
