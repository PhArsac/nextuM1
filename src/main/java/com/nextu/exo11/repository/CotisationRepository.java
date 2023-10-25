package com.nextu.exo11.repository;

import com.nextu.exo11.entity.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotisationRepository extends JpaRepository<Cotisation, Long> {
}
