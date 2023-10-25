package com.nextu.exo11.repository;

import com.nextu.exo11.entity.TypeMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMembreRepository extends JpaRepository<TypeMembre, Long> {
}
