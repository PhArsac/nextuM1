package com.nextu.exo11.controller;

import com.nextu.exo11.entity.dto.ActiviteDTO;
import com.nextu.exo11.service.ActiviteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all activite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Read all activite", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)
    })
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

    @Operation(summary = "Get an activite by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Read an Activite",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Activite not found", content = @Content)
    })
    @Parameters(value = {
            @Parameter(name = "id", description = "Id of the Activite to get")
    })
    @GetMapping(value = "/activite/{id}", produces = "application/json")
    public ResponseEntity<ActiviteDTO> getActivite(@PathVariable long id) {
        Optional<ActiviteDTO> activite = activiteService.findById(id);
        if (activite.isPresent()) {
            return ResponseEntity.ok(activite.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Post an activite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The posted Activite",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid activite supplied", content = @Content)
    })
    @Parameters(value = {
            @Parameter(name = "activite", description = "Activite to be posted",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))})
    })
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

    @Operation(summary = "Put an activite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The put Activite",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid activite supplied", content = @Content)
    })
    @Parameters(value = {
            @Parameter(name = "activite", description = "Activite to be put",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))})
    })
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
    @Operation(summary = "Delete an activite with this id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Activite to delete",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ActiviteDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid activite supplied", content = @Content)
    })
    @Parameters(value = {
            @Parameter(name = "id", description = "Id of the Activite to delete")
    })
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
