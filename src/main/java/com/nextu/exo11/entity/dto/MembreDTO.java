package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MembreDTO implements Serializable {

    private long idMembre;

    private String nom;
    private String prenom;
    private String numeroTelephone;
    private Date dateNaissance;
    private VilleDTO ville;
    private FamilleDTO famille;
    private TypeMembreDTO typeMembre;
    private List<InscriptionDTO> inscriptionList;

    public long getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(long idMembre) {
        this.idMembre = idMembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public VilleDTO getVille() {
        return ville;
    }

    public void setVille(VilleDTO ville) {
        this.ville = ville;
    }

    public FamilleDTO getFamille() {
        return famille;
    }

    public void setFamille(FamilleDTO famille) {
        this.famille = famille;
    }

    public TypeMembreDTO getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(TypeMembreDTO typeMembre) {
        this.typeMembre = typeMembre;
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
        MembreDTO membreDTO = (MembreDTO) o;
        return idMembre == membreDTO.idMembre && Objects.equals(nom, membreDTO.nom) && Objects.equals(prenom, membreDTO.prenom) && Objects.equals(numeroTelephone, membreDTO.numeroTelephone) && Objects.equals(dateNaissance, membreDTO.dateNaissance) && Objects.equals(ville, membreDTO.ville) && Objects.equals(famille, membreDTO.famille) && Objects.equals(typeMembre, membreDTO.typeMembre) && Objects.equals(inscriptionList, membreDTO.inscriptionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembre, nom, prenom, numeroTelephone, dateNaissance, ville, famille, typeMembre, inscriptionList);
    }

    @Override
    public String toString() {
        return "MembreDTO{" +
                "idMembre=" + idMembre +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", ville=" + ville +
                ", famille=" + famille +
                ", typeMembre=" + typeMembre +
                ", inscriptionList=" + inscriptionList +
                '}';
    }
}
