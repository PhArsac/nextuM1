package com.nextu.exo11.service.mapper;

import com.nextu.exo11.entity.Activite;
import com.nextu.exo11.entity.dto.ActiviteDTO;
import com.nextu.exo11.entity.dto.InscriptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActiviteMapper {

    private static final Logger log = LoggerFactory.getLogger(ActiviteMapper.class);

    public ActiviteDTO toDto (Activite activite) {
        if (activite == null) { return null; }
        ActiviteDTO activiteDTO = new ActiviteDTO();

        activiteDTO.setIdActivite(activite.getIdActivite());
        activiteDTO.setCode(activite.getCode());
        activiteDTO.setLibelle(activite.getLibelle());
        activiteDTO.setTarifNormal(activite.getTarifNormal());
        activiteDTO.setTarifReduit(activite.getTarifReduit());
        List<InscriptionDTO> inscriptionDTOList = new ArrayList<>();
        activiteDTO.setInscriptionList(inscriptionDTOList);

        return activiteDTO;
    }

    public Activite toEntity (ActiviteDTO activiteDTO) {
        if (activiteDTO == null) {
            return null;
        }
        Activite activite = new Activite(activiteDTO.getCode(), activiteDTO.getLibelle(), activiteDTO.getTarifNormal(), activiteDTO.getTarifReduit());
        activite.setIdActivite(activiteDTO.getIdActivite());

        return activite;
    }
}
