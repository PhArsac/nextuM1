package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.Objects;

public class ChequeDTO implements Serializable {

    private long idCheque;
    private String banque;
    private String numero;
    private ModePaiementDTO modePaiement;

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
        ChequeDTO chequeDTO = (ChequeDTO) o;
        return idCheque == chequeDTO.idCheque && Objects.equals(banque, chequeDTO.banque) && Objects.equals(numero, chequeDTO.numero) && Objects.equals(modePaiement, chequeDTO.modePaiement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCheque, banque, numero, modePaiement);
    }

    @Override
    public String toString() {
        return "ChequeDTO{" +
                "idCheque=" + idCheque +
                ", banque='" + banque + '\'' +
                ", numero='" + numero + '\'' +
                ", modePaiement=" + modePaiement +
                '}';
    }
}
