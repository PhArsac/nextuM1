package com.nextu.exo11.service;

import com.nextu.exo11.entity.dto.VilleDTO;

import java.util.List;
import java.util.Optional;

public interface VilleService {

    List<Optional<VilleDTO>> findAll();
    Optional<VilleDTO> findById(long id);

    Optional<VilleDTO> findByLibelle(String libelle);

    Optional<VilleDTO> ajouter(VilleDTO villeDTO);

    Optional<VilleDTO> modifier(VilleDTO villeDTO);

    void supprimer(VilleDTO villeDTO);

}
