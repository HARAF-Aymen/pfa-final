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
            produit.setAchat(savedAchat);
            System.out.println("Produit associé: " + produit.getId());
        }

        produitRepository.saveAll(produits);
        System.out.println("Produits sauvegardés");

        savedAchat.setProduits(produits);

        return savedAchat;
    }



    public Achat updateAchat(Long id, AchatDTO achatDTO) {
        Achat achat = achatRepository.findById(id).orElseThrow(() -> new RuntimeException("Achat not found"));

        achat.setDate(achatDTO.getDate());

        if (achat.getProduits() != null) {
            for (Produit produit : achat.getProduits()) {
                produit.setAchat(null);
            }
        }

        List<Produit> produits = produitRepository.findAllById(achatDTO.getProduitIds());
        for (Produit produit : produits) {
            produit.setAchat(achat);
        }

        produitRepository.saveAll(produits);

        achat.setProduits(produits);

        return achatRepository.save(achat);
    }


    public void deleteAchat(Long id){
        achatRepository.deleteById(id);
    }
}
