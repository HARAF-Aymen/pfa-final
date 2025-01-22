package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.CommandeRepository;
import com.gestion.stock.gestion_stock.Repository.FournisseurRepository;
import com.gestion.stock.gestion_stock.Repository.ProduitRepository;
import com.gestion.stock.gestion_stock.entities.Commande;
import com.gestion.stock.gestion_stock.entities.Fournisseur;
import com.gestion.stock.gestion_stock.entities.Produit;
import com.gestion.stock.gestion_stock.request.CommandeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private ProduitRepository produitRepository;


    public List<Commande> getAllCommandes(){
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id){
        return commandeRepository.findById(id).orElse(null);
    }

    public Commande addCommande(CommandeDTO commandeDTO) {
        Commande commande = new Commande();
        commande.setDate(commandeDTO.getDate());

        Fournisseur fournisseur = fournisseurRepository.findById(commandeDTO.getFournisseurId())
                .orElseThrow(() -> new RuntimeException("Fournisseur not found with id: " + commandeDTO.getFournisseurId()));
        commande.setFournisseur(fournisseur);

        Commande savedCommande = commandeRepository.save(commande);

        List<Produit> produits = produitRepository.findAllById(commandeDTO.getProduitIds());
        for (Produit produit : produits) {
            int quantiteCommandee = commandeDTO.getQuantiteParProduit().get(produit.getId());



            produit.setQuantite(produit.getQuantite() + quantiteCommandee);
            produit.setCommande(savedCommande);
        }

        produitRepository.saveAll(produits);

        savedCommande.setProduits(produits);

        return commandeRepository.save(savedCommande);
    }




    public Commande updateCommande(Long id,CommandeDTO commandeDTO){
        Commande commande = new Commande();
        commande.setDate(commandeDTO.getDate());

        Fournisseur fournisseur = fournisseurRepository.findById(commandeDTO.getFournisseurId())
                .orElseThrow(() -> new RuntimeException("Fournisseur not found with id: " + commandeDTO.getFournisseurId()));
        commande.setFournisseur(fournisseur);

        Commande savedCommande = commandeRepository.save(commande);

        List<Produit> produits = produitRepository.findAllById(commandeDTO.getProduitIds());
        for (Produit produit : produits) {
            int quantiteCommandee = commandeDTO.getQuantiteParProduit().get(produit.getId());



            produit.setQuantite(produit.getQuantite() + quantiteCommandee);
            produit.setCommande(savedCommande);
        }

        produitRepository.saveAll(produits);

        savedCommande.setProduits(produits);

        return commandeRepository.save(savedCommande);

    }

    public void deleteCommande(Long id){
        commandeRepository.deleteById(id);
    }
}
