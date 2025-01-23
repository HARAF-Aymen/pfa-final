package com.gestion.stock.gestion_stock.controller;

import com.gestion.stock.gestion_stock.Repository.ProduitRepository;
import com.gestion.stock.gestion_stock.entities.Produit;
import com.gestion.stock.gestion_stock.request.ProduitDTO;
import com.gestion.stock.gestion_stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduitById(id);
    }

    @PostMapping
    public Produit createProduit(@RequestBody ProduitDTO produitDTO) {
        return produitService.createProduit(produitDTO);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody ProduitDTO produitDTO){
        return produitService.updateProduit(id, produitDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public long count(){
        return produitRepository.count();
    }

    @GetMapping("/prodparcat")
    public ResponseEntity<Map<String, Long>> getProduitsParCategorie() {
        return ResponseEntity.ok(produitService.getProduitsParCategorie());
    }

}
