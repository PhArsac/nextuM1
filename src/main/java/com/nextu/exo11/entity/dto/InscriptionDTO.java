package com.nextu.exo11.entity.dto;

import java.io.Serializable;
import java.util.List;

public class InscriptionDTO implements Serializable {

    private long idInscription;

    private float montantTotal;
    private CotisationDTO cotisation;
    private List<ActiviteDTO> activiteList;

    private MembreDTO membre;

    private List<ModePaiementDTO> modePaiementList;
}
