package com.nextu.exo11.service;

import com.nextu.exo11.entity.dto.MembreDTO;

import java.util.List;
import java.util.Optional;

public interface MembreService {

    List<Optional<MembreDTO>> findAll();
    Optional<MembreDTO> findById(long id);

    Optional<MembreDTO> ajouter(MembreDTO membreDTO);

    Optional<MembreDTO> modifier(MembreDTO membreDTO);

    void supprimer(MembreDTO membreDTO);


}
