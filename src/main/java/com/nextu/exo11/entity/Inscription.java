package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInscription;

    @Column(nullable = false)
    private float montantTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCotisation")
    private Cotisation cotisation;

    @ManyToMany(mappedBy = "inscriptions",fetch = FetchType.EAGER)
    private Set<Activite> activites = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMembre")
    private Membre membre;

    @OneToMany(targetEntity = ModePaiement.class, mappedBy = "inscription")
    private Set<ModePaiement> modePaiements;


    public Inscription() {
    }

    public Inscription(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(long idInscription) {
        this.idInscription = idInscription;
    }

    public float getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Cotisation getCotisation() {
        return cotisation;
    }

    public void setCotisation(Cotisation cotisation) {
        this.cotisation = cotisation;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Set<Activite> getActivites() {
        return activites;
    }

    public void setActivites(Set<Activite> activites) {
        this.activites = activites;
    }
}
