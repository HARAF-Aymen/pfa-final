package com.gestion.stock.gestion_stock.controller;

import com.gestion.stock.gestion_stock.entities.Categorie;
import com.gestion.stock.gestion_stock.request.CategorieDTO;
import com.gestion.stock.gestion_stock.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorie(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    @PostMapping
    public Categorie addCategorie(@RequestBody CategorieDTO categorieDTO) {
        return categorieService.createCategorie(categorieDTO);
    }

    @PutMapping("/{id}")
    public Categorie updateCategorie(@PathVariable Long id, @RequestBody CategorieDTO categorieDTO) {
        return categorieService.updateCategorie(id, categorieDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }

    @GetMapping("/count")
    public long getCategorieCount() {
        return categorieService.count();
    }







}
