package com.nextu.exo11.service.impl;

import com.nextu.exo11.entity.Ville;
import com.nextu.exo11.entity.dto.VilleDTO;
import com.nextu.exo11.repository.VilleRepository;
import com.nextu.exo11.service.VilleService;
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
public class VilleServiceImpl implements VilleService {
    private static final Logger log = LoggerFactory.getLogger(VilleServiceImpl.class);

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private VilleMapper villeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Optional<VilleDTO>> findAll() {
        log.info("find all Ville");
        List<Optional<VilleDTO>> resultList = new ArrayList<>();
        List<Ville> villeList = villeRepository.findAll();
        for (Ville ville : villeList) {
            if (ville != null) {
                resultList.add(Optional.of(villeMapper.toDto(ville)));
            }
        }
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VilleDTO> findById(long id) {
        log.info("find Ville by Id");
        try {
            Optional<Ville> ville = villeRepository.findById(id);
            if (ville.isPresent()) {
                return Optional.of(villeMapper.toDto(ville.get()));
            }
        } catch (Exception e) {
            log.info("Ville avec l'id {} not found", id);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<VilleDTO> findByLibelle(String libelle) {
        log.info("find Ville by Libelle");
        try {
            Optional<Ville> ville = villeRepository.findByLibelle(libelle);
            if (ville.isPresent()) {
                return Optional.of(villeMapper.toDto(ville.get()));
            }
        } catch (Exception e) {
            log.info("Ville {} not found", libelle);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<VilleDTO> ajouter(VilleDTO villeDTO) {
        Ville ville = villeRepository.saveAndFlush(villeMapper.toEntity(villeDTO));
        return Optional.of(villeMapper.toDto(ville));
    }

    @Override
    @Transactional
    public Optional<VilleDTO> modifier(VilleDTO villeDTO) {
        Ville ville = villeRepository.saveAndFlush(villeMapper.toEntity(villeDTO));
        return Optional.of(villeMapper.toDto(ville));
    }

    @Override
    @Transactional
    public void supprimer(VilleDTO villeDTO) {
        villeRepository.deleteById(villeDTO.getIdVille());
    }
}
