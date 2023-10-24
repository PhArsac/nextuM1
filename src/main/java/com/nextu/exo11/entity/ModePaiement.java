package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ModePaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idModePaiement;

    @Column(nullable = false)
    private float montantPaye;

    @Column(nullable = false)
    private Date datePaiement;

    @OneToOne
    @JoinColumn(name = "idCheque", referencedColumnName = "idCheque")
    private Cheque cheque;

    @OneToOne
    @JoinColumn(name = "idCarteBancaire", referencedColumnName = "idCarteBancaire")
    private CarteBancaire carteBancaire;

    @OneToOne
    @JoinColumn(name = "idVirement", referencedColumnName = "idVirement")
    private Virement virement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idInscription")
    private Inscription inscription;


    public ModePaiement() {
    }

    public ModePaiement(float montantPaye, Date datePaiement) {
        this.montantPaye = montantPaye;
        this.datePaiement = datePaiement;
    }

    public long getIdModePaiement() {
        return idModePaiement;
    }

    public void setIdModePaiement(long idModePaiement) {
        this.idModePaiement = idModePaiement;
    }

    public float getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public CarteBancaire getCarteBancaire() {
        return carteBancaire;
    }

    public void setCarteBancaire(CarteBancaire carteBancaire) {
        this.carteBancaire = carteBancaire;
    }
}
