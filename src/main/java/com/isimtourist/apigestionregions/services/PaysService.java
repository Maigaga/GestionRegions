package com.isimtourist.apigestionregions.services;

import com.isimtourist.apigestionregions.entity.Pays;
import java.util.List;

public interface PaysService {
    Pays creerPays(Pays pays);
    List<Pays> lire();
    Pays modifier(Long id, Pays pays);
    String supprimer(Long id);
    Pays trouverPaysParNom(String nom);
}