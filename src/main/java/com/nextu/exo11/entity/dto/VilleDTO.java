package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class VilleDTO implements Serializable {

    private long idVille;

    private String libelle;

    private String code;

    private boolean estATarifReduit;

    private List<MembreDTO> membreList;

    public long getIdVille() {
        return idVille;
    }

    public void setIdVille(long idVille) {
        this.idVille = idVille;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEstATarifReduit() {
        return estATarifReduit;
    }

    public void setEstATarifReduit(boolean estATarifReduit) {
        this.estATarifReduit = estATarifReduit;
    }

    public List<MembreDTO> getMembreList() {
        return membreList;
    }

    public void setMembreList(List<MembreDTO> membreList) {
        this.membreList = membreList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VilleDTO villeDTO = (VilleDTO) o;
        return idVille == villeDTO.idVille && estATarifReduit == villeDTO.estATarifReduit && Objects.equals(libelle, villeDTO.libelle) && Objects.equals(code, villeDTO.code) && Objects.equals(membreList, villeDTO.membreList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVille, libelle, code, estATarifReduit, membreList);
    }

    @Override
    public String toString() {
        return "VilleDTO{" +
                "idVille=" + idVille +
                ", libelle='" + libelle + '\'' +
                ", code='" + code + '\'' +
                ", estATarifReduit=" + estATarifReduit +
                ", membreList=" + membreList +
                '}';
    }
}
