package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVille;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = true)
    private String code;

    @OneToMany(targetEntity = Membre.class, mappedBy = "ville")
    private Set<Membre> membres;

    public Ville() {
    }

    public Ville(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
    }

    public long getIdVille() {
        return idVille;
    }

    public void setIdVille(long idVille) {
        this.idVille = idVille;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Membre> getMembres() {
        return membres;
    }

    public void setMembres(Set<Membre> membres) {
        this.membres = membres;
    }
}
