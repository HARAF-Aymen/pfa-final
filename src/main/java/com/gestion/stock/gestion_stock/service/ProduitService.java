package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.ProduitRepository;
import com.gestion.stock.gestion_stock.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit introuvable avec l'id :" +id));
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit produitDetails) {
        Produit produit = getProduitById(id);
        produit.setNom(produitDetails.getNom());
        produit.setCategorie(produitDetails.getCategorie());
        produit.setPrix(produitDetails.getPrix());
        produit.setQuantite(produitDetails.getQuantite());
        produit.setDescription(produitDetails.getDescription());
        produit.setImageUrl(produitDetails.getImageUrl());
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
