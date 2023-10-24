package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idActivite;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private float tarifNormal;

    @Column(nullable = false)
    private float tarifReduit;

    @ManyToMany
    @JoinTable(
            name = "Activite_Inscription",
            joinColumns = {@JoinColumn(name = "idActivite")},
            inverseJoinColumns = {@JoinColumn(name = "idInscription")}
    )
    private Set<Inscription> inscriptions = new HashSet<>();


    public Activite() {
    }

    public Activite(String code, String libelle, float tarifNormal, float tarifReduit) {
        this.code = code;
        this.libelle = libelle;
        this.tarifNormal = tarifNormal;
        this.tarifReduit = tarifReduit;
    }

    public long getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(long idActivite) {
        this.idActivite = idActivite;
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

    public float getTarifNormal() {
        return tarifNormal;
    }

    public void setTarifNormal(float tarifNormal) {
        this.tarifNormal = tarifNormal;
    }

    public float getTarifReduit() {
        return tarifReduit;
    }

    public void setTarifReduit(float tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
