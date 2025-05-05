package com.isimtourist.apigestionregions.services;

import com.isimtourist.apigestionregions.entity.Population;

import java.util.List;

public interface PopulationService {
    Population ajouterPopulation(Long regionId, int annee, long nombre);
    List<Population> getPopulationsByRegion(Long regionId);
    Population modifierPopulation(Long id, Population population);
    void supprimerPopulation(Long id);
    Population getPopulationByAnnee(Long regionId, int annee);
}