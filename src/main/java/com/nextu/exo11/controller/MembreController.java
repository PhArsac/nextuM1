package com.nextu.exo11.controller;

import com.nextu.exo11.entity.dto.MembreDTO;
import com.nextu.exo11.service.MembreService;
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
public class MembreController {
    private static final Logger log = LoggerFactory.getLogger(MembreController.class);

    @Autowired
    private MembreService membreService;

    @GetMapping(value = "/membre", produces = "application/json")
    public ResponseEntity<List<MembreDTO>> getMembres() {
        List<MembreDTO> resultList = new ArrayList<>();
        List<Optional<MembreDTO>> memberList = membreService.findAll();
        for (Optional<MembreDTO> membreDTO : memberList) {
            if (membreDTO.isPresent()) {
                resultList.add(membreDTO.get());
            }
        }
        return ResponseEntity.ok(resultList);
    }

    @GetMapping(value = "/membre/{id}", produces = "application/json")
    public ResponseEntity<MembreDTO> getMembre(@PathVariable long id) {
        Optional<MembreDTO> membre = membreService.findById(id);
        if (membre.isPresent()) {
            return ResponseEntity.ok(membre.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/membre", produces = "application/json")
    public ResponseEntity<MembreDTO> createMembre(@RequestBody MembreDTO membre) {
        if (membre == null) {
            return ResponseEntity.noContent().build();
        }
        try {
            Optional<MembreDTO> result = membreService.ajouter(membre);
            if (result.isPresent()) {
                return ResponseEntity.ok(result.get());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/membre", produces = "application/json")
    public ResponseEntity<MembreDTO> updateMembre(@RequestBody MembreDTO membre) {
        if (membre == null) {
            return ResponseEntity.noContent().build();
        }
        Optional<MembreDTO> result = membreService.modifier(membre);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/membre/{id}", produces = "application/json")
    public ResponseEntity<MembreDTO> deleteMembre(@PathVariable long id) {
        Optional<MembreDTO> membreDTO = membreService.findById(id);
        if (membreDTO.isPresent()) {
            membreService.supprimer(membreDTO.get());
            ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
