package com.nextu.exo11.entity;

import jakarta.persistence.*;

@Entity
public class CarteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarteBancaire;

    @Column(nullable = false)
    private String banque;

    @Column(nullable = false)
    private String transaction;

    @OneToOne
    @JoinColumn(name = "idModePaiement", referencedColumnName = "idModePaiement")
    private ModePaiement modePaiement;

    public CarteBancaire() {
    }

    public CarteBancaire(String banque, String transaction) {
        this.banque = banque;
        this.transaction = transaction;
    }

    public long getIdCarteBancaire() {
        return idCarteBancaire;
    }

    public void setIdCarteBancaire(long idCarteBancaire) {
        this.idCarteBancaire = idCarteBancaire;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String numtransactionero) {
        this.transaction = transaction;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }
}
