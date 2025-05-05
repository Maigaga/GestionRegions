package com.isimtourist.apigestionregions.repository;

import com.isimtourist.apigestionregions.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Regions, Long> {
    Optional<Regions> findByCodeRegion(String codeRegion);
    List<Regions> findByPaysNom(String paysNom);
    List<Regions> findAllByOrderByNomAsc();
}