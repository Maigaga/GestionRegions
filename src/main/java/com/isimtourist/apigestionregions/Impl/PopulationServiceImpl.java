package com.isimtourist.apigestionregions.Impl;

import com.isimtourist.apigestionregions.entity.Population;
import com.isimtourist.apigestionregions.entity.Regions;
import com.isimtourist.apigestionregions.repository.PopulationRepository;
import com.isimtourist.apigestionregions.repository.RegionRepository;
import com.isimtourist.apigestionregions.services.PopulationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PopulationServiceImpl implements PopulationService {
    private final PopulationRepository populationRepository;
    private final RegionRepository regionRepository;

    public PopulationServiceImpl(PopulationRepository populationRepository,
                                 RegionRepository regionRepository) {
        this.populationRepository = populationRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Population ajouterPopulation(Long regionId, int annee, long nombre) {
        Regions region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Région non trouvée"));

        // Vérifier si cette année existe déjà
        Optional<Population> existante = populationRepository.findByRegionIdAndAnnee(regionId, annee);
        if(existante.isPresent()) {
            throw new RuntimeException("Données de population existantes pour cette année");
        }

        Population population = new Population();
        population.setAnnee(annee);
        population.setNombre(nombre);
        population.setRegion(region);

        return populationRepository.save(population);
    }

    @Override
    public List<Population> getPopulationsByRegion(Long regionId) {
        return populationRepository.findByRegionId(regionId);
    }

    @Override
    public Population modifierPopulation(Long id, Population population) {
        return populationRepository.findById(id)
                .map(pop -> {
                    pop.setNombre(population.getNombre());
                    return populationRepository.save(pop);
                })
                .orElseThrow(() -> new RuntimeException("Données de population non trouvées"));
    }

    @Override
    public void supprimerPopulation(Long id) {
        populationRepository.deleteById(id);
    }

    @Override
    public Population getPopulationByAnnee(Long regionId, int annee) {
        return populationRepository.findByRegionIdAndAnnee(regionId, annee)
                .orElseThrow(() -> new RuntimeException("Données non trouvées pour cette année"));
    }
}