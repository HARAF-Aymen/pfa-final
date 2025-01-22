package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.AchatRepository;
import com.gestion.stock.gestion_stock.Repository.CategorieRepository;
import com.gestion.stock.gestion_stock.Repository.CommandeRepository;
import com.gestion.stock.gestion_stock.Repository.ProduitRepository;
import com.gestion.stock.gestion_stock.entities.Achat;
import com.gestion.stock.gestion_stock.entities.Categorie;
import com.gestion.stock.gestion_stock.entities.Commande;
import com.gestion.stock.gestion_stock.entities.Produit;
import com.gestion.stock.gestion_stock.request.ProduitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private AchatRepository achatRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit introuvable avec l'id :" +id));
    }

    public Produit createProduit(ProduitDTO produitDTO) {
        Produit produit = new Produit();

        Achat achat = achatRepository.findById((produitDTO.getAchatId()))
                .orElseThrow(() -> new RuntimeException("Commande not found with id: " + produitDTO.getAchatId()));;

        Commande commande = commandeRepository.findById((produitDTO.getCommandeId()))
                .orElseThrow(() -> new RuntimeException("Commande not found with id: " + produitDTO.getCommandeId()));;

        Categorie categorie = categorieRepository.findById(produitDTO.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + produitDTO.getCategorieId()));;

        produit.setCategorie(categorie);
        produit.setPrix(produitDTO.getPrix());
        produit.setQuantite(produitDTO.getQuantité());
        produit.setDescription(produitDTO.getDescription());
        produit.setImageUrl(produitDTO.getImageUrl());
        produit.setNom(produitDTO.getNom());
        produit.setCommande(commande);
        produit.setAchat(achat);

        return produitRepository.save(produit);

    }

    public Produit updateProduit(Long id, ProduitDTO produitDTO) {
        Produit existingProduit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit not found with id: " + id));

        Produit produit = new Produit();

        Achat achat = achatRepository.findById((produitDTO.getAchatId()))
                .orElseThrow(() -> new RuntimeException("Commande not found with id: " + produitDTO.getAchatId()));;


        Commande commande = commandeRepository.findById((produitDTO.getCommandeId()))
                .orElseThrow(() -> new RuntimeException("Commande not found with id: " + produitDTO.getCommandeId()));;

        Categorie categorie = categorieRepository.findById(produitDTO.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + produitDTO.getCategorieId()));;

        produit.setCategorie(categorie);
        produit.setPrix(produitDTO.getPrix());
        produit.setQuantite(produitDTO.getQuantité());
        produit.setDescription(produitDTO.getDescription());
        produit.setImageUrl(produitDTO.getImageUrl());
        produit.setNom(produitDTO.getNom());
        produit.setCommande(commande);
        produit.setAchat(achat);

        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
