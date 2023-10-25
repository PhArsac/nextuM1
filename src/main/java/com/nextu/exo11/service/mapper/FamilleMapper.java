package com.nextu.exo11.service.mapper;

import com.nextu.exo11.entity.Famille;
import com.nextu.exo11.entity.dto.FamilleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FamilleMapper {
    private static final Logger log = LoggerFactory.getLogger(FamilleMapper.class);

    public FamilleDTO toDto (Famille famille) {
        if (famille == null) { return null; }
        FamilleDTO familleDTO = new FamilleDTO();

        familleDTO.setIdFamille(famille.getIdFamille());
        familleDTO.setNomFamille(famille.getNomDeFamille());

        return familleDTO;
    }

    public Famille toEntity (FamilleDTO familleDTO) {
        if (familleDTO == null) {
            return null;
        }
        Famille famille = new Famille(familleDTO.getNomFamille());
        famille.setIdFamille(familleDTO.getIdFamille());

        return famille;
    }

}
