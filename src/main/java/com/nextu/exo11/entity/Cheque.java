package com.nextu.exo11.entity;

import jakarta.persistence.*;

@Entity
public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCheque;

    @Column(nullable = false)
    private String banque;

    @Column(nullable = false)
    private String numero;

    @OneToOne
    @JoinColumn(name = "idModePaiement", referencedColumnName = "idModePaiement")
    private ModePaiement modePaiement;

    public Cheque() {
    }

    public Cheque(String banque, String numero) {
        this.banque = banque;
        this.numero = numero;
    }

    public long getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(long idCheque) {
        this.idCheque = idCheque;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }
}
