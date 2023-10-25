package com.nextu.exo11.service.mapper;

import com.nextu.exo11.entity.Membre;
import com.nextu.exo11.entity.TypeMembre;
import com.nextu.exo11.entity.Ville;
import com.nextu.exo11.entity.dto.MembreDTO;
import com.nextu.exo11.entity.dto.TypeMembreDTO;
import com.nextu.exo11.entity.dto.VilleDTO;
import com.nextu.exo11.service.TypeMembreService;
import com.nextu.exo11.service.VilleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembreMapper {
    private static final Logger log = LoggerFactory.getLogger(MembreMapper.class);

    @Autowired
    private TypeMembreMapper typeMembreMapper;
    @Autowired
    private VilleMapper villeMapper;
    @Autowired
    private FamilleMapper familleMapper;

    public MembreDTO toDto (Membre membre) {
        if (membre == null) { return null; }
        MembreDTO membreDTO = new MembreDTO();

        membreDTO.setIdMembre(membre.getIdMembre());
        membreDTO.setNom(membre.getNom());
        membreDTO.setPrenom(membre.getPrenom());
        membreDTO.setDateNaissance(membre.getDateNaissance());
        membreDTO.setNumeroTelephone(membre.getNumeroTelephone());
        membreDTO.setTypeMembre(typeMembreMapper.toDto(membre.getTypeMembre()));
        membreDTO.setVille(villeMapper.toDto(membre.getVille()));
        membreDTO.setFamille(familleMapper.toDto(membre.getFamille()));

        return membreDTO;
    }

    public Membre toEntity (MembreDTO membreDTO) {
        if (membreDTO == null) {
            return null;
        }
        Membre membre = new Membre(membreDTO.getNom(), membreDTO.getPrenom(), membreDTO.getNumeroTelephone(), membreDTO.getDateNaissance());
        membre.setIdMembre(membreDTO.getIdMembre());

        return membre;
    }

}
