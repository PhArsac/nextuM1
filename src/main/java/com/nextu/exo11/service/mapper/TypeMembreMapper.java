package com.nextu.exo11.service.mapper;

import com.nextu.exo11.entity.TypeMembre;
import com.nextu.exo11.entity.dto.TypeMembreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TypeMembreMapper {

    private static final Logger log = LoggerFactory.getLogger(TypeMembreMapper.class);

    public TypeMembreDTO toDto (TypeMembre typeMembre) {
        if (typeMembre == null) { return null; }
        TypeMembreDTO typeMembreDTO = new TypeMembreDTO();

        typeMembreDTO.setIdTypeMembre(typeMembre.getIdTypeMembre());
        typeMembreDTO.setTypeMembre(typeMembre.getTypeMembre());

        return typeMembreDTO;
    }

    public TypeMembre toEntity (TypeMembreDTO typeMembreDTO) {
        if (typeMembreDTO == null) {
            return null;
        }
        TypeMembre typeMembre = new TypeMembre(typeMembreDTO.getTypeMembre());
        typeMembre.setIdTypeMembre(typeMembreDTO.getIdTypeMembre());

        return typeMembre;
    }

}
