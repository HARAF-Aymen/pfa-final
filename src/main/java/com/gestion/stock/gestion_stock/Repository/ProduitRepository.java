package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProduitRepository extends JpaRepository<Produit, Long> {


    @Query("SELECT p.categorie.nom, COUNT(p) FROM Produit p GROUP BY p.categorie.nom")
    List<Object[]> countProduitsParCategorie();
}