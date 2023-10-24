package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "famille")
public class Famille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFamille;

    @Column(name = "nom_famille")
    private String nomDeFamille;

    @OneToMany(targetEntity = Membre.class, mappedBy = "famille")
    private Set<Membre> membres;

    public Famille() {
    }

    public Famille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public long getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(long idFamille) {
        this.idFamille = idFamille;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public Set<Membre> getMembres() {
        return membres;
    }

    public void setMembres(Set<Membre> membres) {
        this.membres = membres;
    }
}
