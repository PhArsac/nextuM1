package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ActiviteDTO implements Serializable {

    private long idActivite;

    private String code;

    private String libelle;
    private float tarifNormal;

    private float tarifReduit;

    private List<InscriptionDTO> inscriptionList;

    public long getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(long idActivite) {
        this.idActivite = idActivite;
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

    public float getTarifNormal() {
        return tarifNormal;
    }

    public void setTarifNormal(float tarifNormal) {
        this.tarifNormal = tarifNormal;
    }

    public float getTarifReduit() {
        return tarifReduit;
    }

    public void setTarifReduit(float tarifReduit) {
        this.tarifReduit = tarifReduit;
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
        ActiviteDTO that = (ActiviteDTO) o;
        return idActivite == that.idActivite && Float.compare(tarifNormal, that.tarifNormal) == 0 && Float.compare(tarifReduit, that.tarifReduit) == 0 && Objects.equals(code, that.code) && Objects.equals(libelle, that.libelle) && Objects.equals(inscriptionList, that.inscriptionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActivite, code, libelle, tarifNormal, tarifReduit, inscriptionList);
    }

    @Override
    public String toString() {
        return "ActiviteDTO{" +
                "idActivite=" + idActivite +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", tarifNormal=" + tarifNormal +
                ", tarifReduit=" + tarifReduit +
                ", inscriptionList=" + inscriptionList +
                '}';
    }
}
