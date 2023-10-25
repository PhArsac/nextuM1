package com.nextu.exo11.entity.dto;

import com.nextu.exo11.entity.CarteBancaire;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ModePaiementDTO implements Serializable {

    private long idModePaiementDTO;

    private float montantPaye;

    private Date datePaiement;

    private ChequeDTO cheque;

    private VirementDTO virement;

    private CarteBancaireDTO carteBancaire;

    private InscriptionDTO inscription;

    public long getIdModePaiementDTO() {
        return idModePaiementDTO;
    }

    public void setIdModePaiementDTO(long idModePaiementDTO) {
        this.idModePaiementDTO = idModePaiementDTO;
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

    public ChequeDTO getCheque() {
        return cheque;
    }

    public void setCheque(ChequeDTO cheque) {
        this.cheque = cheque;
    }

    public VirementDTO getVirement() {
        return virement;
    }

    public void setVirement(VirementDTO virement) {
        this.virement = virement;
    }

    public CarteBancaireDTO getCarteBancaire() {
        return carteBancaire;
    }

    public void setCarteBancaire(CarteBancaireDTO carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    public InscriptionDTO getInscription() {
        return inscription;
    }

    public void setInscription(InscriptionDTO inscription) {
        this.inscription = inscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModePaiementDTO that = (ModePaiementDTO) o;
        return idModePaiementDTO == that.idModePaiementDTO && Float.compare(montantPaye, that.montantPaye) == 0 && Objects.equals(datePaiement, that.datePaiement) && Objects.equals(cheque, that.cheque) && Objects.equals(virement, that.virement) && Objects.equals(carteBancaire, that.carteBancaire) && Objects.equals(inscription, that.inscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModePaiementDTO, montantPaye, datePaiement, cheque, virement, carteBancaire, inscription);
    }

    @Override
    public String toString() {
        return "ModePaiementDTO{" +
                "idModePaiementDTO=" + idModePaiementDTO +
                ", montantPaye=" + montantPaye +
                ", datePaiement=" + datePaiement +
                ", cheque=" + cheque +
                ", virement=" + virement +
                ", carteBancaire=" + carteBancaire +
                ", inscription=" + inscription +
                '}';
    }
}
