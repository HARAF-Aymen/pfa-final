package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
