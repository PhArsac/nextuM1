package com.nextu.exo11.repository;

import com.nextu.exo11.entity.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Long> {
}
