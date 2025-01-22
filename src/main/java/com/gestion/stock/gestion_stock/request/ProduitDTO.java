package com.gestion.stock.gestion_stock.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {
    private Long id;
    private String nom;
    private Double prix;
    private int quantité;
    private String description;
    private String imageUrl;
    private Long categorieId;
    private Long commandeId;

    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Double getPrix() {
        return prix;
    }

    public int getQuantité() {
        return quantité;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}
