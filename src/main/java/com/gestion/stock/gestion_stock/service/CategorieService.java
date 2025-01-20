package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.CategorieRepository;
import com.gestion.stock.gestion_stock.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories(){
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id : " +id));
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Long id, Categorie categorieDetails) {
        Categorie categorie = getCategorieById(id);
        categorie.setNom(categorieDetails.getNom());
        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
