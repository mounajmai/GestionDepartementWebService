package com.example.gestiondepartement.models;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "niveau", nullable = false)
    private String niveau;

    @Column(name = "absences")
    private int absences;

    @Column(name = "presences")
    private int presences;

    @ElementCollection
    @CollectionTable(name = "etudiant_notes", joinColumns = @JoinColumn(name = "etudiant_id"))
    @Column(name = "note")
    private List<Double> notes;

    // Constructeurs, Getters et Setters

    public Etudiant() {}

    public Etudiant(String nom, String prenom, String email, String niveau, int absences, int presences, List<Double> notes) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.niveau = niveau;
        this.absences = absences;
        this.presences = presences;
        this.notes = notes;
    }

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

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }

    public int getPresences() {
        return presences;
    }

    public void setPresences(int presences) {
        this.presences = presences;
    }

    public List<Double> getNotes() {
        return notes;
    }

    public void setNotes(List<Double> notes) {
        this.notes = notes;
    }
}
