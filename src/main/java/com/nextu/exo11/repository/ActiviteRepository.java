package com.nextu.exo11.repository;

import com.nextu.exo11.entity.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {

    /*
    @Query("select idActivite, code, libelle, tarifNormal, tarifReduit from activite a where a.code = :code")
    Activite findByCode(@Param("code") String code);
    */
}
