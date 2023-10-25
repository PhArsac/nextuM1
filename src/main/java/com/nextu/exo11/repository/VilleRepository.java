package com.nextu.exo11.repository;

import com.nextu.exo11.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

    Optional<Ville> findByLibelle(String libelle);

}
