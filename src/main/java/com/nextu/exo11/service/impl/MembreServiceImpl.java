package com.nextu.exo11.service.impl;

import com.nextu.exo11.entity.Famille;
import com.nextu.exo11.entity.Membre;
import com.nextu.exo11.entity.Ville;
import com.nextu.exo11.entity.dto.FamilleDTO;
import com.nextu.exo11.entity.dto.MembreDTO;
import com.nextu.exo11.entity.dto.TypeMembreDTO;
import com.nextu.exo11.entity.dto.VilleDTO;
import com.nextu.exo11.repository.MembreRepository;
import com.nextu.exo11.service.FamilleService;
import com.nextu.exo11.service.MembreService;
import com.nextu.exo11.service.TypeMembreService;
import com.nextu.exo11.service.VilleService;
import com.nextu.exo11.service.mapper.FamilleMapper;
import com.nextu.exo11.service.mapper.MembreMapper;
import com.nextu.exo11.service.mapper.TypeMembreMapper;
import com.nextu.exo11.service.mapper.VilleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MembreServiceImpl implements MembreService {
    private static final Logger log = LoggerFactory.getLogger(MembreServiceImpl.class);

    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private MembreMapper membreMapper;

    @Autowired
    private TypeMembreMapper typeMembreMapper;
    private TypeMembreService typeMembreService;
    @Autowired
    private FamilleMapper familleMapper;
    private FamilleService familleService;
    @Autowired
    private VilleMapper villeMapper;
    private VilleService villeService;

    public MembreServiceImpl(TypeMembreService typeMembreService, VilleService villeService, FamilleService familleService) {
        this.typeMembreService = typeMembreService;
        this.villeService = villeService;
        this.familleService = familleService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Optional<MembreDTO>> findAll() {
        log.info("find all Membre");
        List<Optional<MembreDTO>> resultList = new ArrayList<>();
        List<Membre> membreList = membreRepository.findAll();
        for (Membre membre : membreList) {
            if (membre != null) {
                resultList.add(Optional.of(membreMapper.toDto(membre)));
            }
        }
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembreDTO> findById(long id) {
        log.info("find Membre by Id");
        try {
            Optional<Membre> membre = membreRepository.findById(id);
            if (membre.isPresent()) {
                return Optional.of(membreMapper.toDto(membre.get()));
            }
        } catch (Exception e) {
            log.info("Membre with id {} not found", id);
        }
        return Optional.empty();

    }

    @Override
    @Transactional
    public Optional<MembreDTO> ajouter(MembreDTO membreDTO) {
        Membre membre = membreMapper.toEntity(membreDTO);
        Optional<FamilleDTO> familleDTO = familleService.findByNomDeFamille(membreDTO.getNom());
        if (familleDTO.isPresent()) {
            // lien vers la famille déjà existante
            membre.setFamille(familleMapper.toEntity(familleDTO.get()));
        } else {
            // ajout d'une famille
            Famille famille = new Famille(membreDTO.getNom());
            Optional<FamilleDTO> familleRetour = familleService.ajouter(familleMapper.toDto(famille));
            if (familleRetour.isPresent()) {
                membre.setFamille(familleMapper.toEntity(familleRetour.get()));
            }
        }
        if (membreDTO.getTypeMembre() != null) {
            Optional<TypeMembreDTO> typeMembreDTO = typeMembreService.findById(membreDTO.getTypeMembre().getIdTypeMembre());
            if (typeMembreDTO.isPresent()) {
                membre.setTypeMembre(typeMembreMapper.toEntity(typeMembreDTO.get()));
            }
        }
        if (membreDTO.getVille() != null) {
            Optional<VilleDTO> villeDTO = villeService.findById(membreDTO.getVille().getIdVille());
            if (villeDTO.isPresent()) {
                // recherche de la ville sur son ID
                membre.setVille((villeMapper.toEntity(villeDTO.get())));
            } else {
                // recherche de la ville sur son libelle
                Optional<VilleDTO> villeDTO1 = villeService.findByLibelle(membreDTO.getVille().getLibelle());
                if (villeDTO1.isPresent()) {
                    membre.setVille(villeMapper.toEntity(villeDTO1.get()));
                } else {
                    // création de la ville
                    Ville ville = new Ville("", membreDTO.getVille().getLibelle(), false);
                    Optional<VilleDTO> villeRetour = villeService.ajouter(villeMapper.toDto(ville));
                    if (villeRetour.isPresent()) {
                        membre.setVille(villeMapper.toEntity(villeRetour.get()));
                    }
                }
            }
        }

        Membre membreRetour = membreRepository.save(membre);
        return Optional.of(membreMapper.toDto(membreRetour));
    }

    @Override
    @Transactional
    public Optional<MembreDTO> modifier(MembreDTO membreDTO) {
        Membre membre = membreRepository.saveAndFlush(membreMapper.toEntity(membreDTO));
        return Optional.of(membreMapper.toDto(membre));
    }

    @Override
    @Transactional
    public void supprimer(MembreDTO membreDTO) {
        membreRepository.deleteById(membreDTO.getIdMembre());
    }
}
