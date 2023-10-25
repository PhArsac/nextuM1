package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CotisationDTO implements Serializable {

    private long idCotisation;
    private String code;
    private String libelle;
    private float montant;
    private List<InscriptionDTO> inscriptionList;

    public long getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(long idCotisation) {
        this.idCotisation = idCotisation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public List<InscriptionDTO> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<InscriptionDTO> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CotisationDTO that = (CotisationDTO) o;
        return idCotisation == that.idCotisation && Float.compare(montant, that.montant) == 0 && Objects.equals(code, that.code) && Objects.equals(libelle, that.libelle) && Objects.equals(inscriptionList, that.inscriptionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCotisation, code, libelle, montant, inscriptionList);
    }

    @Override
    public String toString() {
        return "CotisationDTO{" +
                "idCotisation=" + idCotisation +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", montant=" + montant +
                ", inscriptionList=" + inscriptionList +
                '}';
    }
}
