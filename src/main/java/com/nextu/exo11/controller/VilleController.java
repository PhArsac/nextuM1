package com.nextu.exo11.controller;

import com.nextu.exo11.entity.dto.VilleDTO;
import com.nextu.exo11.service.VilleService;
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
public class VilleController {
    private static final Logger log = LoggerFactory.getLogger(VilleController.class);

    @Autowired
    private VilleService villeService;

    @GetMapping(value = "/ville", produces = "application/json")
    public ResponseEntity<List<VilleDTO>> getActivites() {
        List<VilleDTO> resultList = new ArrayList<>();
        List<Optional<VilleDTO>> villeList = villeService.findAll();
        for (Optional<VilleDTO> villeDTO : villeList) {
            if (villeDTO.isPresent()) {
                resultList.add(villeDTO.get());
            }
        }
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/ville/{id}", produces = "application/json")
    public ResponseEntity<VilleDTO> getActivite(@PathVariable long id) {
        Optional<VilleDTO> ville = villeService.findById(id);
        if (ville.isPresent()) {
            return ResponseEntity.ok(ville.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/ville", produces = "application/json")
    public ResponseEntity<VilleDTO> createActivite(@RequestBody VilleDTO ville) {
        if (ville == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<VilleDTO> result = villeService.ajouter(ville);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/ville", produces = "application/json")
    public ResponseEntity<VilleDTO> updateActivite(@RequestBody VilleDTO ville) {
        if (ville == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<VilleDTO> result = villeService.modifier(ville);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/ville/{id}", produces = "application/json")
    public ResponseEntity<VilleDTO> deleteActivite(@PathVariable long id) {
        Optional<VilleDTO> villeDTO = villeService.findById(id);
        if (villeDTO.isPresent()) {
            villeService.supprimer(villeDTO.get());
            ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
