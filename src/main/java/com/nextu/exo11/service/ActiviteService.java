package com.nextu.exo11.service;

import com.nextu.exo11.entity.dto.ActiviteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Classe de service pour l'entité Activite
 * @author Philippe Arsac
 */
public interface ActiviteService {


    /**
     * Lit toutes les Activite depuis la BDD
     * @return liste des Activite lues transformées en DTO
     */
    List<Optional<ActiviteDTO>> findAll();

    /**
     * Lit une Activite en BDD à partir de son identifiant
     * @param id : identifiant de l'Activite à lire
     * @return l'Activité lue et transformée en DTO
     */
    Optional<ActiviteDTO> findById(long id);

    /**
     * Ajoute une Activite en BDD
     * @param activiteDTO Activite à ajouter au format DTO
     * @return Activite ajoutée avec son identifiant auto-genéré par la BDD au format DTO
     */
    Optional<ActiviteDTO> ajouter(ActiviteDTO activiteDTO);

    /**
     * Modifie une Activité en BDD si elle existe (id renseigné) ou ajoute l'Activite en BDD
     * @param activiteDTO Activité à modifier au format DTO
     * @return Activite modifée avec son identifiant auto-genéré par la BDD en cas de création au format DTO
     */
    Optional<ActiviteDTO> modifier(ActiviteDTO activiteDTO);

    /**
     * Supprime une Activite en BDD
     * @param activiteDTO Activite à supprimer au format DTO
     */
    void supprimer(ActiviteDTO activiteDTO);
}
