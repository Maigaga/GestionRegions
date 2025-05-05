package com.isimtourist.apigestionregions.services;

import com.isimtourist.apigestionregions.entity.Regions;
import java.util.List;
import java.util.Map;

public interface RegionService {
    Regions creerRegion(Regions region);
    List<Regions> lire();
    List<Regions> lireRegionsParPays(String paysNom);
    Regions modifier(Long id, Regions region);
    String supprimer(Long id);
    Regions ajouterPopulation(Long regionId, int annee, long population);
}