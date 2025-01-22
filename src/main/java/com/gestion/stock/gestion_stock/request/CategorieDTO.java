package com.gestion.stock.gestion_stock.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CategorieDTO {
    private Long id;
    private String nom;
    private List<Long> produitIds;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setProduitIds(List<Long> produitIds) {
        this.produitIds = produitIds;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Long> getProduitIds() {
        return produitIds;
    }
}
