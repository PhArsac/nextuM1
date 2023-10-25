package com.nextu.exo11.controller;

import com.nextu.exo11.entity.dto.ActiviteDTO;
import com.nextu.exo11.service.ActiviteService;
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
public class ActiviteController {

    private static final Logger log = LoggerFactory.getLogger(ActiviteController.class);

    @Autowired
    private ActiviteService activiteService;

    @GetMapping(value = "/activite", produces = "application/json")
    public ResponseEntity<List<ActiviteDTO>> getActivites() {
        List<ActiviteDTO> resultList = new ArrayList<>();
        List<Optional<ActiviteDTO>> activiteList = activiteService.findAll();
        for (Optional<ActiviteDTO> activiteDTO : activiteList) {
            if (activiteDTO.isPresent()) {
                resultList.add(activiteDTO.get());
            }
        }
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/activite/{id}", produces = "application/json")
    public ResponseEntity<ActiviteDTO> getActivite(@PathVariable long id) {
        Optional<ActiviteDTO> activite = activiteService.findById(id);
        if (activite.isPresent()) {
            return ResponseEntity.ok(activite.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/activite", produces = "application/json")
    public ResponseEntity<ActiviteDTO> createActivite(@RequestBody ActiviteDTO activite) {
        if (activite == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<ActiviteDTO> result = activiteService.ajouter(activite);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/activite", produces = "application/json")
    public ResponseEntity<ActiviteDTO> updateActivite(@RequestBody ActiviteDTO activite) {
        if (activite == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<ActiviteDTO> result = activiteService.modifier(activite);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/activite/{id}", produces = "application/json")
    public ResponseEntity<ActiviteDTO> deleteActivite(@PathVariable long id) {
        Optional<ActiviteDTO> activiteDTO = activiteService.findById(id);
        if (activiteDTO.isPresent()) {
            activiteService.supprimer(activiteDTO.get());
            ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
