package com.nextu.exo11.repository;

import com.nextu.exo11.entity.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementRepository extends JpaRepository<Virement, Long> {
}
