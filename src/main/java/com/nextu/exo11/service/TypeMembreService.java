package com.nextu.exo11.service;

import com.nextu.exo11.entity.dto.TypeMembreDTO;

import java.util.List;
import java.util.Optional;

public interface TypeMembreService {

    List<Optional<TypeMembreDTO>> findAll();
    Optional<TypeMembreDTO> findById(long id);

    Optional<TypeMembreDTO> ajouter(TypeMembreDTO typeMembreDTO);

    Optional<TypeMembreDTO> modifier(TypeMembreDTO typeMembreDTO);

    void supprimer(TypeMembreDTO typeMembreDTO);


}
