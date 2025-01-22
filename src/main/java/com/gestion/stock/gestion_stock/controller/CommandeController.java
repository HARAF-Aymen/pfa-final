package com.gestion.stock.gestion_stock.controller;

import com.gestion.stock.gestion_stock.entities.Commande;
import com.gestion.stock.gestion_stock.request.CommandeDTO;
import com.gestion.stock.gestion_stock.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommande(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    @PostMapping
    public Commande addCommande(@RequestBody CommandeDTO commandeDTO) {
        return commandeService.addCommande(commandeDTO);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody CommandeDTO commandeDTO) {
        return commandeService.updateCommande(id, commandeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}
