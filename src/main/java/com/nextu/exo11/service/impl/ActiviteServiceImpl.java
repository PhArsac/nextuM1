package com.nextu.exo11.service.impl;

import com.nextu.exo11.entity.Activite;
import com.nextu.exo11.entity.dto.ActiviteDTO;
import com.nextu.exo11.repository.ActiviteRepository;
import com.nextu.exo11.service.ActiviteService;
import com.nextu.exo11.service.mapper.ActiviteMapper;
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
public class ActiviteServiceImpl implements ActiviteService {

    private static final Logger log = LoggerFactory.getLogger(ActiviteServiceImpl.class);

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private ActiviteMapper activiteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Optional<ActiviteDTO>> findAll() {
        log.info("find all Activite");
        List<Optional<ActiviteDTO>> resultList = new ArrayList<>();
        List<Activite> activiteList = activiteRepository.findAll();
        for (Activite activite : activiteList) {
            if (activite != null) {
                resultList.add(Optional.of(activiteMapper.toDto(activite)));
            }
        }
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ActiviteDTO> findById(long id) {
        log.info("find Activite by Id");
        try {
            Optional<Activite> activite = activiteRepository.findById(id);
            if (activite.isPresent()) {
                return Optional.of(activiteMapper.toDto(activite.get()));
            }
        } catch (Exception e) {
            log.info("Activite with id {} not found", id);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ActiviteDTO> ajouter(ActiviteDTO activiteDTO) {
        Activite activite = activiteRepository.saveAndFlush(activiteMapper.toEntity(activiteDTO));
        return Optional.of(activiteMapper.toDto(activite));
    }

    @Override
    @Transactional
    public Optional<ActiviteDTO> modifier(ActiviteDTO activiteDTO) {
        Activite activite = activiteRepository.saveAndFlush(activiteMapper.toEntity(activiteDTO));
        return Optional.of(activiteMapper.toDto(activite));
    }

    @Override
    @Transactional
    public void supprimer(ActiviteDTO activiteDTO) {
        activiteRepository.deleteById(activiteDTO.getIdActivite());
    }
}
