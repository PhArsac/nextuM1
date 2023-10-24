package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCotisation;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private float montant;

    @OneToMany(targetEntity = Inscription.class, mappedBy = "cotisation")
    private Set<Inscription> inscriptions;

    public Cotisation() {
    }

    public Cotisation(String code, String libelle, float montant) {
        this.code = code;
        this.libelle = libelle;
        this.montant = montant;
    }

    public long getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(long idCotisation) {
        this.idCotisation = idCotisation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
