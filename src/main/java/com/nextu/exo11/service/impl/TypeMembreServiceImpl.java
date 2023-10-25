package com.nextu.exo11.service.impl;

import com.nextu.exo11.entity.TypeMembre;
import com.nextu.exo11.entity.dto.TypeMembreDTO;
import com.nextu.exo11.repository.TypeMembreRepository;
import com.nextu.exo11.service.TypeMembreService;
import com.nextu.exo11.service.mapper.TypeMembreMapper;
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
public class TypeMembreServiceImpl implements TypeMembreService {
    private static final Logger log = LoggerFactory.getLogger(TypeMembreServiceImpl.class);

    @Autowired
    private TypeMembreRepository typeMembreRepository;

    @Autowired
    private TypeMembreMapper typeMembreMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Optional<TypeMembreDTO>> findAll() {
        log.info("find all Type Membre");
        List<Optional<TypeMembreDTO>> resultList = new ArrayList<>();
        List<TypeMembre> typeMembreList = typeMembreRepository.findAll();
        for (TypeMembre typeMembre : typeMembreList) {
            if (typeMembre != null) {
                resultList.add(Optional.of(typeMembreMapper.toDto(typeMembre)));
            }
        }
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TypeMembreDTO> findById(long id) {
        log.info("find Type Membre by Id");
        try {
            Optional<TypeMembre> typeMembre = typeMembreRepository.findById(id);
            if (typeMembre.isPresent()) {
                return Optional.of(typeMembreMapper.toDto(typeMembre.get()));
            }
        } catch (Exception e) {
            log.info("Type Membre {} not found", id);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<TypeMembreDTO> ajouter(TypeMembreDTO typeMembreDTO) {
        TypeMembre typeMembre = typeMembreRepository.saveAndFlush(typeMembreMapper.toEntity(typeMembreDTO));
        return Optional.of(typeMembreMapper.toDto(typeMembre));
    }

    @Override
    @Transactional
    public Optional<TypeMembreDTO> modifier(TypeMembreDTO typeMembreDTO) {
        TypeMembre typeMembre = typeMembreRepository.saveAndFlush(typeMembreMapper.toEntity(typeMembreDTO));
        return Optional.of(typeMembreMapper.toDto(typeMembre));
    }

    @Override
    @Transactional
    public void supprimer(TypeMembreDTO typeMembreDTO) {
        typeMembreRepository.deleteById(typeMembreDTO.getIdTypeMembre());
    }
}
