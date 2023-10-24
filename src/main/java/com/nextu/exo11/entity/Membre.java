package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMembre;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column
    private String numeroTelephone;

    @Column
    private Date dateNaissance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVille")
    private Ville ville;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypeMembre")
    private TypeMembre typeMembre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFamille")
    private Famille famille;

    @OneToMany(targetEntity = Inscription.class, mappedBy = "membre")
    private Set<Inscription> inscriptions;

    public Membre() {
    }

    public Membre(String nom, String prenom, String numeroTelephone, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.dateNaissance = dateNaissance;
    }

    public long getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(long idMembre) {
        this.idMembre = idMembre;
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

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public TypeMembre getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(TypeMembre typeMembre) {
        this.typeMembre = typeMembre;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
