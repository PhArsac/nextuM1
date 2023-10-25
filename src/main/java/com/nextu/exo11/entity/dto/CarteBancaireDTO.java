package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.Objects;

public class CarteBancaireDTO implements Serializable {

    private long idCarteBanqaire;
    private String banque;
    private String transaction;
    private ModePaiementDTO modePaiement;

    public long getIdCarteBanqaire() {
        return idCarteBanqaire;
    }

    public void setIdCarteBanqaire(long idCarteBanqaire) {
        this.idCarteBanqaire = idCarteBanqaire;
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

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public ModePaiementDTO getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiementDTO modePaiement) {
        this.modePaiement = modePaiement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarteBancaireDTO that = (CarteBancaireDTO) o;
        return idCarteBanqaire == that.idCarteBanqaire && Objects.equals(banque, that.banque) && Objects.equals(transaction, that.transaction) && Objects.equals(modePaiement, that.modePaiement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarteBanqaire, banque, transaction, modePaiement);
    }

    @Override
    public String toString() {
        return "CarteBancaireDTO{" +
                "idCarteBanqaire=" + idCarteBanqaire +
                ", banque='" + banque + '\'' +
                ", transaction='" + transaction + '\'' +
                ", modePaiement=" + modePaiement +
                '}';
    }
}
