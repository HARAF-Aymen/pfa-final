package com.gestion.stock.gestion_stock.controller;

import com.gestion.stock.gestion_stock.entities.Achat;
import com.gestion.stock.gestion_stock.request.AchatDTO;
import com.gestion.stock.gestion_stock.service.AchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achat")
public class AchatController {

    @Autowired
    private AchatService achatService;

    @GetMapping
    public List<Achat> getAllAchats() {
        return achatService.getAllAchats();
    }

    @GetMapping("/{id}")
    public Achat getAchat(@PathVariable Long id) {
        return achatService.getAchatById(id);
    }

    @PostMapping
    public Achat addAchat(@RequestBody AchatDTO achatDTO) {
        return achatService.addAchat(achatDTO);
    }

    @PutMapping("/{id}")
    public Achat updateAchat(@PathVariable Long id, @RequestBody AchatDTO achatDTO) {
        return achatService.updateAchat(id, achatDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAchat(@PathVariable Long id) {
        achatService.deleteAchat(id);
    }
}
