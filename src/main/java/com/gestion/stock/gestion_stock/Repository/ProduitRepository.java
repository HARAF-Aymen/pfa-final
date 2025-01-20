package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategorie(String categorie);
}