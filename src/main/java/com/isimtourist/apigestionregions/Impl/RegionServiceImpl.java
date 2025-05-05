package com.isimtourist.apigestionregions.Impl;
import com.isimtourist.apigestionregions.services.PaysService;
import com.isimtourist.apigestionregions.entity.Regions;
import com.isimtourist.apigestionregions.entity.Pays;
import com.isimtourist.apigestionregions.repository.RegionRepository;
import com.isimtourist.apigestionregions.services.RegionService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final PaysService paysService;

    public RegionServiceImpl(RegionRepository regionRepository, PaysService paysService) {
        this.regionRepository = regionRepository;
        this.paysService = paysService;
    }

    @Override
    public Regions creerRegion(Regions region) {
        // Par défaut, le pays est le Mali
        Pays mali = paysService.trouverPaysParNom("Mali");
        region.setPays(mali);
        return regionRepository.save(region);
    }

    @Override
    public List<Regions> lire() {
        return regionRepository.findAllByOrderByNomAsc();
    }

    @Override
    public List<Regions> lireRegionsParPays(String paysNom) {
        return regionRepository.findByPaysNom(paysNom);
    }

    @Override
    public Regions modifier(Long id, Regions region) {
        return regionRepository.findById(id)
                .map(r -> {
                    r.setNom(region.getNom());
                    r.setCodeRegion(region.getCodeRegion());
                    r.setDomaineActivite(region.getDomaineActivite());
                    r.setSuperficie(region.getSuperficie());
                    r.setLangue(region.getLangue());
                    if (region.getPays() != null) {
                        r.setPays(region.getPays());
                    }
                    return regionRepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Région non trouvée"));
    }

    @Override
    public String supprimer(Long id) {
        regionRepository.deleteById(id);
        return "Région supprimée";
    }

    @Override
    public Regions ajouterPopulation(Long regionId, int annee, long population) {
        return null;
    }


}