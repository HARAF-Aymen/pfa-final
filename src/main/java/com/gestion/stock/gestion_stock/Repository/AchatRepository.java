package com.gestion.stock.gestion_stock.Repository;


import com.gestion.stock.gestion_stock.entities.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepository extends JpaRepository<Achat,Long> {

}
