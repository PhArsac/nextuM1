package com.nextu.exo11.controller;

import com.nextu.exo11.entity.dto.TypeMembreDTO;
import com.nextu.exo11.service.TypeMembreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TypeMembreController {
    private static final Logger log = LoggerFactory.getLogger(TypeMembreController.class);

    @Autowired
    private TypeMembreService typeMembreService;

    @GetMapping(value = "/typeMembre", produces = "application/json")
    public ResponseEntity<List<TypeMembreDTO>> getTypeMembres() {
        List<TypeMembreDTO> resultList = new ArrayList<>();
        List<Optional<TypeMembreDTO>> typeMembreList = typeMembreService.findAll();
        for (Optional<TypeMembreDTO> typeMembreDTO : typeMembreList) {
            if (typeMembreDTO.isPresent()) {
                resultList.add(typeMembreDTO.get());
            }
        }
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/typeMembre/{id}", produces = "application/json")
    public ResponseEntity<TypeMembreDTO> getTypeMembre(@PathVariable long id) {
        Optional<TypeMembreDTO> typeMembre = typeMembreService.findById(id);
        if (typeMembre.isPresent()) {
            return ResponseEntity.ok(typeMembre.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/typeMembre", produces = "application/json")
    public ResponseEntity<TypeMembreDTO> createActivite(@RequestBody TypeMembreDTO typeMembre) {
        if (typeMembre == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<TypeMembreDTO> result = typeMembreService.ajouter(typeMembre);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/typeMembre", produces = "application/json")
    public ResponseEntity<TypeMembreDTO> updateActivite(@RequestBody TypeMembreDTO activite) {
        if (activite == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<TypeMembreDTO> result = typeMembreService.modifier(activite);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/typeMembre/{id}", produces = "application/json")
    public ResponseEntity<TypeMembreDTO> deleteActivite(@PathVariable long id) {
        Optional<TypeMembreDTO> activiteDTO = typeMembreService.findById(id);
        if (activiteDTO.isPresent()) {
            typeMembreService.supprimer(activiteDTO.get());
            ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
