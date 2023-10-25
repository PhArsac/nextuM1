package com.nextu.exo11.repository;

import com.nextu.exo11.entity.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {
}
