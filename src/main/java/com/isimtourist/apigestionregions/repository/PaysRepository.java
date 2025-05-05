package com.isimtourist.apigestionregions.repository;

import com.isimtourist.apigestionregions.entity.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaysRepository extends JpaRepository<Pays, Long> {
    Optional<Pays> findByNom(String nom);
    Optional<Pays> findByCode(String code);
}