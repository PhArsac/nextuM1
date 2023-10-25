package com.nextu.exo11.service;

import com.nextu.exo11.entity.dto.FamilleDTO;
import com.nextu.exo11.entity.dto.VilleDTO;

import java.util.List;
import java.util.Optional;

public interface FamilleService {

    List<Optional<FamilleDTO>> findAll();
    Optional<FamilleDTO> findById(long id);
    Optional<FamilleDTO> findByNomDeFamille(String libelle);

    Optional<FamilleDTO> ajouter(FamilleDTO familleDTO);

    Optional<FamilleDTO> modifier(FamilleDTO familleDTO);

    void supprimer(FamilleDTO familleDTO);


}
