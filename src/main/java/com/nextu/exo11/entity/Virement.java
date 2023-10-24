package com.nextu.exo11.entity;

import jakarta.persistence.*;

@Entity
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVirement;

    @Column(nullable = false)
    private String banque;


    @Column(nullable = false)
    private String compte;


    @OneToOne
    @JoinColumn(name = "idModePaiement", referencedColumnName = "idModePaiement")
    private ModePaiement modePaiement;

    public Virement() {
    }

    public Virement(String banque, String compte) {
        this.banque = banque;
        this.compte = compte;
    }

    public long getIdVirement() {
        return idVirement;
    }

    public void setIdVirement(long idVirement) {
        this.idVirement = idVirement;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }
}
