package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.CategorieRepository;
import com.gestion.stock.gestion_stock.Repository.ProduitRepository;
import com.gestion.stock.gestion_stock.entities.Categorie;
import com.gestion.stock.gestion_stock.entities.Produit;
import com.gestion.stock.gestion_stock.request.CategorieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Categorie> getAllCategories(){
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id : " +id));
    }

    public Categorie createCategorie(CategorieDTO categorieDTO) {
        Categorie categorie = new Categorie();
        categorie.setNom(categorieDTO.getNom());

        categorie = categorieRepository.save(categorie);

        if (categorieDTO.getProduitIds() != null && !categorieDTO.getProduitIds().isEmpty()) {
            List<Produit> produits = produitRepository.findAllById(categorieDTO.getProduitIds());

            for (Produit produit : produits) {
                produit.setCategorie(categorie);
            }

            produitRepository.saveAll(produits);

            categorie.setProduits(produits);
        }

        return categorieRepository.save(categorie);
    }


    public Categorie updateCategorie(Long id, CategorieDTO categorieDTO) {
        Categorie categorie = new Categorie();
        categorie.setNom(categorieDTO.getNom());

        categorie = categorieRepository.save(categorie);

        if (categorieDTO.getProduitIds() != null && !categorieDTO.getProduitIds().isEmpty()) {
            List<Produit> produits = produitRepository.findAllById(categorieDTO.getProduitIds());

            for (Produit produit : produits) {
                produit.setCategorie(categorie);
            }

            produitRepository.saveAll(produits);

            categorie.setProduits(produits);
        }

        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    public long count(){
        return categorieRepository.count();
    }
}
