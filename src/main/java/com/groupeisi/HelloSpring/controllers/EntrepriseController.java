package com.groupeisi.HelloSpring.controllers;

import com.groupeisi.HelloSpring.entities.Entreprise;
import com.groupeisi.HelloSpring.services.EntrepriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;


    @GetMapping
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.findAll();
    }


    @GetMapping("/{raisonSociale}")
    public Entreprise getEntreprise(
            @PathVariable String raisonSociale) {

        return entrepriseService
                .findByRaisonSociale(raisonSociale)
                .orElse(null);
    }


    @PostMapping
    public Entreprise create(
            @RequestBody Entreprise entreprise) {

        return entrepriseService.create(entreprise);
    }


    @PutMapping("/{raisonSociale}")
    public Entreprise update(
            @PathVariable String raisonSociale,
            @RequestBody Entreprise entreprise) {

        entreprise.setRaisonSociale(raisonSociale);

        return entrepriseService.update(entreprise);
    }


    @DeleteMapping("/{raisonSociale}")
    public void delete(
            @PathVariable String raisonSociale) {

        entrepriseService.delete(raisonSociale);
    }
}