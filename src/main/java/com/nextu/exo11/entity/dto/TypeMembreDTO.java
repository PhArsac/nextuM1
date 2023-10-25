package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TypeMembreDTO implements Serializable {

    private long idTypeMembre;

    private String typeMembre;

    private List<MembreDTO> membreList;

    public long getIdTypeMembre() {
        return idTypeMembre;
    }

    public void setIdTypeMembre(long idTypeMembre) {
        this.idTypeMembre = idTypeMembre;
    }

    public String getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
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
        TypeMembreDTO that = (TypeMembreDTO) o;
        return idTypeMembre == that.idTypeMembre && Objects.equals(typeMembre, that.typeMembre) && Objects.equals(membreList, that.membreList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeMembre, typeMembre, membreList);
    }

    @Override
    public String toString() {
        return "TypeMembreDTO{" +
                "idTypeMembre=" + idTypeMembre +
                ", typeMembre='" + typeMembre + '\'' +
                ", membreList=" + membreList +
                '}';
    }
}
