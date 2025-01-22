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
public class AchatDTO {

    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private List<Long> produitIds;

    private Map<Long, Integer> quantiteParProduit;

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
