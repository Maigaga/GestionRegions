package com.isimtourist.apigestionregions.controller;

import com.isimtourist.apigestionregions.entity.Regions;
;
import com.isimtourist.apigestionregions.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    @PostMapping
    public Regions creer(@RequestBody Regions region) {
        return regionService.creerRegion(region);
    }

    @GetMapping
    public List<Regions> lire() {
        return regionService.lire();
    }

    @GetMapping("/pays/{paysNom}")
    public List<Regions> lireParPays(@PathVariable String paysNom) {
        return regionService.lireRegionsParPays(paysNom);
    }

    @PutMapping("/{id}")
    public Regions modifier(@PathVariable Long id, @RequestBody Regions region) {
        return regionService.modifier(id, region);
    }

    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable Long id) {
        return regionService.supprimer(id);
    }

    @PostMapping("/{id}/population")
    public Regions ajouterPopulation(
            @PathVariable Long id,
            @RequestParam int annee,
            @RequestParam long population) {
        return regionService.ajouterPopulation(id, annee, population);
    }
}