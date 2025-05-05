package com.isimtourist.apigestionregions.controller;

import com.isimtourist.apigestionregions.entity.Population;
import com.isimtourist.apigestionregions.services.PopulationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions/{regionId}/populations")
public class PopulationController {
    private final PopulationService populationService;

    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @PostMapping
    public Population ajouterPopulation(
            @PathVariable Long regionId,
            @RequestParam int annee,
            @RequestParam long nombre) {
        return populationService.ajouterPopulation(regionId, annee, nombre);
    }

    @GetMapping
    public List<Population> getPopulations(@PathVariable Long regionId) {
        return populationService.getPopulationsByRegion(regionId);
    }

    @GetMapping("/{annee}")
    public Population getPopulationByAnnee(
            @PathVariable Long regionId,
            @PathVariable int annee) {
        return populationService.getPopulationByAnnee(regionId, annee);
    }

    @PutMapping("/{id}")
    public Population modifierPopulation(
            @PathVariable Long id,
            @RequestBody Population population) {
        return populationService.modifierPopulation(id, population);
    }

    @DeleteMapping("/{id}")
    public void supprimerPopulation(@PathVariable Long id) {
        populationService.supprimerPopulation(id);
    }
}