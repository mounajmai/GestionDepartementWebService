package com.example.gestiondepartement.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CadreAdministratif")
public class CadreAdministratif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;


    private int joursTravailPrevus; // Nombre de jours de travail prévus
    private int joursAbsencePrevus; // Nombre de jours d'absence prévus

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }



    public int getJoursTravailPrevus() {
        return joursTravailPrevus;
    }

    public void setJoursTravailPrevus(int joursTravailPrevus) {
        this.joursTravailPrevus = joursTravailPrevus;
    }

    public int getJoursAbsencePrevus() {
        return joursAbsencePrevus;
    }

    public void setJoursAbsencePrevus(int joursAbsencePrevus) {
        this.joursAbsencePrevus = joursAbsencePrevus;
    }
}
