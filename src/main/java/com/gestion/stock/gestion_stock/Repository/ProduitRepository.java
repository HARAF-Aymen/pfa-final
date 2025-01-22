package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
}