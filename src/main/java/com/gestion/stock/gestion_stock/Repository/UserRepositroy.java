package com.gestion.stock.gestion_stock.Repository;

import com.gestion.stock.gestion_stock.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositroy extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
