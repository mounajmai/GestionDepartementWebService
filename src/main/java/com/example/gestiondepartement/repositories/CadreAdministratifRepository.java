package com.example.gestiondepartement.repositories;
import com.example.gestiondepartement.models.CadreAdministratif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreAdministratifRepository extends JpaRepository<CadreAdministratif, Long> {
}
