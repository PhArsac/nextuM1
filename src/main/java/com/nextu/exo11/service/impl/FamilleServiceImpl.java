package com.nextu.exo11.service.impl;

import com.nextu.exo11.entity.Famille;
import com.nextu.exo11.entity.dto.FamilleDTO;
import com.nextu.exo11.repository.FamilleRepository;
import com.nextu.exo11.service.FamilleService;
import com.nextu.exo11.service.mapper.FamilleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FamilleServiceImpl implements FamilleService {
    private static final Logger log = LoggerFactory.getLogger(FamilleServiceImpl.class);

    @Autowired
    private FamilleRepository familleRepository;

    @Autowired
    private FamilleMapper familleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Optional<FamilleDTO>> findAll() {
        log.info("find all Famille");
        List<Optional<FamilleDTO>> resultList = new ArrayList<>();
        List<Famille> familleList = familleRepository.findAll();
        for (Famille famille : familleList) {
            if (famille != null) {
                resultList.add(Optional.of(familleMapper.toDto(famille)));
            }
        }
        return resultList;

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FamilleDTO> findById(long id) {
        log.info("find Famille by Id");
        try {
            Optional<Famille> famille = familleRepository.findById(id);
            if (famille.isPresent()) {
                return Optional.of(familleMapper.toDto(famille.get()));
            }
        } catch (Exception e) {
            log.info("Famille with id {} not found", id);
        }
        return Optional.empty();

    }

    @Override
    public Optional<FamilleDTO> findByNomDeFamille(String libelle) {
        log.info("find Famille by Name");
        try {
            Optional<Famille> famille = familleRepository.findByNomDeFamille(libelle);
            if (famille.isPresent()) {
                return Optional.of(familleMapper.toDto(famille.get()));
            }
        } catch (Exception e) {
            log.info("Famille with name {} not found", libelle);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<FamilleDTO> ajouter(FamilleDTO familleDTO) {
        Famille famille = familleRepository.saveAndFlush(familleMapper.toEntity(familleDTO));
        return Optional.of(familleMapper.toDto(famille));
    }

    @Override
    @Transactional
    public Optional<FamilleDTO> modifier(FamilleDTO familleDTO) {
        Famille famille = familleRepository.saveAndFlush(familleMapper.toEntity(familleDTO));
        return Optional.of(familleMapper.toDto(famille));
    }

    @Override
    @Transactional
    public void supprimer(FamilleDTO familleDTO) {
        familleRepository.deleteById(familleDTO.getIdFamille());
    }
}
