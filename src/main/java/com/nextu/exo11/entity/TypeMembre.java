package com.nextu.exo11.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_membre")
public class TypeMembre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTypeMembre;

    @Column(nullable = false)
    private String typeMembre;

    @OneToMany(targetEntity = Membre.class, mappedBy = "typeMembre")
    private List<Membre> membres = new ArrayList<>();


    public TypeMembre() {
    }

    public TypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
    }

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

    public List<Membre> getMembres() {
        return membres;
    }

}
