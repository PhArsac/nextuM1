package com.nextu.exo11.repository;

import com.nextu.exo11.entity.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModePaiementRepository extends JpaRepository<ModePaiement, Long> {
}
