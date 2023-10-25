package com.nextu.exo11.service.mapper;

import com.nextu.exo11.entity.Ville;
import com.nextu.exo11.entity.dto.VilleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VilleMapper {

    private static final Logger log = LoggerFactory.getLogger(VilleMapper.class);

    public VilleDTO toDto (Ville ville) {
        if (ville == null) { return null; }
        VilleDTO villeDTO = new VilleDTO();

        villeDTO.setIdVille(ville.getIdVille());
        villeDTO.setCode(ville.getCode());
        villeDTO.setLibelle(ville.getLibelle());
        villeDTO.setEstATarifReduit(ville.isEstATarifReduit());

        return villeDTO;
    }

    public Ville toEntity (VilleDTO villeDTO) {
        if (villeDTO == null) {
            return null;
        }
        Ville ville = new Ville(villeDTO.getCode(), villeDTO.getLibelle(), villeDTO.isEstATarifReduit());
        ville.setIdVille(villeDTO.getIdVille());

        return ville;
    }

}
