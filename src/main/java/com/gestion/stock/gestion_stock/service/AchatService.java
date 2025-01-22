package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.AchatRepository;
import com.gestion.stock.gestion_stock.Repository.ProduitRepository;
import com.gestion.stock.gestion_stock.entities.Achat;
import com.gestion.stock.gestion_stock.entities.Produit;
import com.gestion.stock.gestion_stock.request.AchatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchatService {

    @Autowired
    private AchatRepository achatRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Achat> getAllAchats(){
        return achatRepository.findAll();
    }

    public Achat getAchatById(Long id){
        return achatRepository.findById(id).orElse(null);
    }

    public Achat addAchat(AchatDTO achatDTO) {
        Achat achat = new Achat();
        achat.setDate(achatDTO.getDate());

        Achat savedAchat = achatRepository.save(achat);
        System.out.println("Achat sauvegardé avec ID: " + savedAchat.getId());

        List<Produit> produits = produitRepository.findAllById(achatDTO.getProduitIds());
        System.out.println("Produits récupérés: " + produits);

        for (Produit produit : produits) {
            int quantiteAchetee = achatDTO.getQuantiteParProduit().get(produit.getId());

            if (produit.getQuantite() < quantiteAchetee) {
                throw new RuntimeException("Stock insuffisant pour le produit : " + produit.getNom());
            }

            produit.setQuantite(produit.getQuantite() - quantiteAchetee);

            produit.setAchat(savedAchat);

            System.out.println("Produit mis à jour : ID = " + produit.getId() + ", Nouvelle quantité = " + produit.getQuantite());
        }

        produitRepository.saveAll(produits);
        System.out.println("Produits sauvegardés avec les nouvelles quantités");

        savedAchat.setProduits(produits);

        return achatRepository.save(savedAchat);
    }



    public Achat updateAchat(Long id, AchatDTO achatDTO) {
        Achat achat = new Achat();
        achat.setDate(achatDTO.getDate());

        Achat savedAchat = achatRepository.save(achat);
        System.out.println("Achat sauvegardé avec ID: " + savedAchat.getId());

        List<Produit> produits = produitRepository.findAllById(achatDTO.getProduitIds());
        System.out.println("Produits récupérés: " + produits);

        for (Produit produit : produits) {
            int quantiteAchetee = achatDTO.getQuantiteParProduit().get(produit.getId());

            if (produit.getQuantite() < quantiteAchetee) {
                throw new RuntimeException("Stock insuffisant pour le produit : " + produit.getNom());
            }

            produit.setQuantite(produit.getQuantite() - quantiteAchetee);

            produit.setAchat(savedAchat);

            System.out.println("Produit mis à jour : ID = " + produit.getId() + ", Nouvelle quantité = " + produit.getQuantite());
        }

        produitRepository.saveAll(produits);
        System.out.println("Produits sauvegardés avec les nouvelles quantités");

        savedAchat.setProduits(produits);

        return achatRepository.save(savedAchat);
    }


    public void deleteAchat(Long id){
        achatRepository.deleteById(id);
    }
}
