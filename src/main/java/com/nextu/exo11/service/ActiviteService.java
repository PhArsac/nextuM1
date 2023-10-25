package com.nextu.exo11.service;

import com.nextu.exo11.entity.dto.ActiviteDTO;

import java.util.List;
import java.util.Optional;

public interface ActiviteService {


    List<Optional<ActiviteDTO>> findAll();
    Optional<ActiviteDTO> findById(long id);

    Optional<ActiviteDTO> ajouter(ActiviteDTO activiteDTO);

    Optional<ActiviteDTO> modifier(ActiviteDTO activiteDTO);

    void supprimer(ActiviteDTO activiteDTO);
}
