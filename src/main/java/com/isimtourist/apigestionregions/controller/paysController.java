package com.isimtourist.apigestionregions.controller;

import com.isimtourist.apigestionregions.entity.Pays;
import com.isimtourist.apigestionregions.services.PaysService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pays")

public class paysController {
    private final PaysService paysService;

    public paysController(PaysService paysService) {
        this.paysService = paysService;
    }


    @PostMapping
    public Pays creer(@RequestBody Pays pays) {
        return paysService.creerPays(pays);
    }

    @GetMapping
    public List<Pays> lire() {
        return paysService.lire();
    }

    @PutMapping("/{id}")
    public Pays modifier(@PathVariable Long id, @RequestBody Pays pays) {
        return paysService.modifier(id, pays);
    }

    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable Long id) {
        return paysService.supprimer(id);
    }
}