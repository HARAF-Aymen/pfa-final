package com.gestion.stock.gestion_stock.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    private Double prix;

    private int quantite;

    private String description;

    private String imageUrl;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;



}
