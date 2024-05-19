package com.example.gestiondepartement.models;

import jakarta.persistence.*;

@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    private int coursPrevus;
    private int coursRealises;



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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getCoursPrevus() {
        return coursPrevus;
    }

    public void setCoursPrevus(int coursPrevus) {
        this.coursPrevus = coursPrevus;
    }

    public int getCoursRealises() {
        return coursRealises;
    }

    public void setCoursRealises(int coursRealises) {
        this.coursRealises = coursRealises;
    }


}
