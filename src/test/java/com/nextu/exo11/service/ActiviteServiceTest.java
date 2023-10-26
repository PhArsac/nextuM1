package com.nextu.exo11.service;

import com.nextu.exo11.entity.Activite;
import com.nextu.exo11.entity.dto.ActiviteDTO;
import com.nextu.exo11.repository.ActiviteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class ActiviteServiceTest {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private ActiviteService activiteService;

    @Test
    public void activiteService_findAllTest(){
        // GIVEN
        Activite activite1 = new Activite("Guitare individuelle", "Cours individuel de guitare - 30 séances de 30 minutes", 580.0f, 565.0f);
        activiteRepository.save(activite1);
        Activite activite2 = new Activite("Guitare collectif", "Cours collectif de guitare - 30 séances de 45 minutes", 430.0f, 415.0f);
        activiteRepository.save(activite2);

        // WHEN
        List<Optional<ActiviteDTO>> optionalList = activiteService.findAll();
        // THEN
        Assert.notNull(optionalList, "liste lue nulle");
        Assert.notEmpty(optionalList, "liste lue vide");
        Assert.isTrue(optionalList.size() >= 2, "La taille de la liste est au moins de 2 enregistrements");
    }

    @Test
    public void activiteService_findbyId_1Test(){
        // GIVEN
        Activite activite1 = new Activite("Guitare individuelle", "Cours individuel de guitare - 30 séances de 30 minutes", 580.0f, 565.0f);
        activiteRepository.save(activite1);
        Activite activite2 = new Activite("Guitare collectif", "Cours collectif de guitare - 30 séances de 45 minutes", 430.0f, 415.0f);
        activiteRepository.save(activite2);

        // WHEN
        Optional<ActiviteDTO> activite = activiteService.findById(1);
        // THEN
        Assert.notNull(activite, "activite 1 lue nulle");
        Assert.isTrue(activite.isPresent(), "L'activite 1 est bien lue");
        Assert.isTrue("Guitare individuelle".compareTo(activite.get().getCode()) == 0, "L'activite 1 est le cours individuel de guitare");
    }
    @Test
    public void activiteService_findbyIdMinus1Test(){
        // GIVEN
        Activite activite1 = new Activite("Guitare individuelle", "Cours individuel de guitare - 30 séances de 30 minutes", 580.0f, 565.0f);
        activiteRepository.save(activite1);
        Activite activite2 = new Activite("Guitare collectif", "Cours collectif de guitare - 30 séances de 45 minutes", 430.0f, 415.0f);
        activiteRepository.save(activite2);

        // WHEN
        Optional<ActiviteDTO> activite = activiteService.findById(-1);
        // THEN
        Assert.notNull(activite, "activite -1 lue nulle");
        Assert.isTrue(activite.isEmpty(), "L'activite -1 est bien vide");
    }

}
