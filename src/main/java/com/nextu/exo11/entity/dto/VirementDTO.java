package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.Objects;

public class VirementDTO implements Serializable {

    private long idVirement;
    private String banque;
    private String compte;
    private ModePaiementDTO modePaiement;

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
        VirementDTO that = (VirementDTO) o;
        return idVirement == that.idVirement && Objects.equals(banque, that.banque) && Objects.equals(compte, that.compte) && Objects.equals(modePaiement, that.modePaiement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVirement, banque, compte, modePaiement);
    }

    @Override
    public String toString() {
        return "VirementDTO{" +
                "idVirement=" + idVirement +
                ", banque='" + banque + '\'' +
                ", compte='" + compte + '\'' +
                ", modePaiement=" + modePaiement +
                '}';
    }
}
