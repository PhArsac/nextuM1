package com.nextu.exo11.repository;

import com.nextu.exo11.entity.Famille;
import com.nextu.exo11.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilleRepository extends JpaRepository<Famille, Long> {

    Optional<Famille> findByNomDeFamille(String nomDeFamille);

}
