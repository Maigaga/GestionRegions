package com.isimtourist.apigestionregions.Impl;

import com.isimtourist.apigestionregions.entity.Pays;
import com.isimtourist.apigestionregions.repository.PaysRepository;

import com.isimtourist.apigestionregions.services.PaysService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {
    private final PaysRepository paysRepository;

    public PaysServiceImpl(PaysRepository paysRepository) {
        this.paysRepository = paysRepository;
    }

    @Override
    public Pays creerPays(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysRepository.findById(id)
                .map(p -> {
                    p.setNom(pays.getNom());
                    p.setCode(pays.getCode());
                    return paysRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        paysRepository.deleteById(id);
        return "Pays supprimé";
    }

    @Override
    public Pays trouverPaysParNom(String nom) {
        return paysRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Pays non trouvé"));
    }
}