package com.gestion.stock.gestion_stock.controller;

import com.gestion.stock.gestion_stock.entities.Fournisseur;
import com.gestion.stock.gestion_stock.request.FournisseurDTO;
import com.gestion.stock.gestion_stock.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseur(@PathVariable Long id) {
        return fournisseurService.getFournisseurById(id);
    }

    @PostMapping
    public Fournisseur addFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
        return fournisseurService.createFournisseur(fournisseurDTO);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody FournisseurDTO fournisseurDTO) {
        return fournisseurService.updateFournisseur(id, fournisseurDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
    }

}
