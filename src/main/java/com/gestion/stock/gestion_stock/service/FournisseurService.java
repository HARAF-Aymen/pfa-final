package com.gestion.stock.gestion_stock.service;

import com.gestion.stock.gestion_stock.Repository.CommandeRepository;
import com.gestion.stock.gestion_stock.Repository.FournisseurRepository;
import com.gestion.stock.gestion_stock.entities.Commande;
import com.gestion.stock.gestion_stock.entities.Fournisseur;
import com.gestion.stock.gestion_stock.request.FournisseurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Fournisseur> getAllFournisseurs(){
        return fournisseurRepository.findAll();
    }

    public Fournisseur getFournisseurById(Long id){
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur createFournisseur(FournisseurDTO fournisseurDTO){
        Fournisseur fournisseur = new Fournisseur();

        fournisseur.setNom(fournisseurDTO.getNom());
        fournisseur.setEmail(fournisseurDTO.getEmail());
        fournisseur.setAdresse(fournisseurDTO.getAdresse());
        fournisseur.setTelephone(fournisseurDTO.getTelephone());
        List<Commande> commandes = commandeRepository.findAllById(fournisseurDTO.getCommandesIds());
        fournisseur.setCommandes(commandes);
        for (Commande commande: commandes){
            commande.setFournisseur(fournisseur);
        }
        commandeRepository.saveAll(commandes);
        return fournisseurRepository.save(fournisseur);
    }

    public Fournisseur updateFournisseur(Long id, FournisseurDTO fournisseurDTO){


        Fournisseur fournisseur = new Fournisseur();

        fournisseur.setNom(fournisseurDTO.getNom());
        fournisseur.setEmail(fournisseurDTO.getEmail());
        fournisseur.setAdresse(fournisseurDTO.getAdresse());
        fournisseur.setTelephone(fournisseurDTO.getTelephone());
        List<Commande> commandes = commandeRepository.findAllById(fournisseurDTO.getCommandesIds());
        fournisseur.setCommandes(commandes);
        for (Commande commande: commandes){
            commande.setFournisseur(fournisseur);
        }
        commandeRepository.saveAll(commandes);
        return fournisseurRepository.save(fournisseur);
    }

    public void deleteFournisseur(Long id){
        fournisseurRepository.deleteById(id);
    }


}
