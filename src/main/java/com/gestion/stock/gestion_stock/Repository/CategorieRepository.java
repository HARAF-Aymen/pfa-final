package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
