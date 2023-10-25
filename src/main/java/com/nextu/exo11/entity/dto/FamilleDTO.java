package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FamilleDTO implements Serializable {

    private long idFamille;
    private String nomFamille;

    private List<MembreDTO> membreList;

    public long getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(long idFamille) {
        this.idFamille = idFamille;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
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
        FamilleDTO that = (FamilleDTO) o;
        return idFamille == that.idFamille && Objects.equals(nomFamille, that.nomFamille) && Objects.equals(membreList, that.membreList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFamille, nomFamille, membreList);
    }

    @Override
    public String toString() {
        return "FamilleDTO{" +
                "idFamille=" + idFamille +
                ", nomFamille='" + nomFamille + '\'' +
                ", membreList=" + membreList +
                '}';
    }
}
