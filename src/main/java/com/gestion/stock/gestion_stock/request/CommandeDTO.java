package com.gestion.stock.gestion_stock.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class CommandeDTO {
    private Long id;
    private Long fournisseurId;
    private List<Long> produitIds;
    private Map<Long, Integer> quantiteParProduit;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Map<Long, Integer> getQuantiteParProduit() {
        return quantiteParProduit;
    }

    public void setQuantiteParProduit(Map<Long, Integer> quantiteParProduit) {
        this.quantiteParProduit = quantiteParProduit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public List<Long> getProduitIds() {
        return produitIds;
    }

    public void setProduitIds(List<Long> produitIds) {
        this.produitIds = produitIds;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
