package com.isimtourist.apigestionregions.repository;

import com.isimtourist.apigestionregions.entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PopulationRepository extends JpaRepository<Population, Long> {
    List<Population> findByRegionId(Long regionId);
    Optional<Population> findByRegionIdAndAnnee(Long regionId, int annee);
}