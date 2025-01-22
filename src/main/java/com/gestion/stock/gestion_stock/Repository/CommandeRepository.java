package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
