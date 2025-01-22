package com.gestion.stock.gestion_stock.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDTO {
    private Long id;
    private String telephone;
    private String adresse;
    private String email;
    private List<Long> commandesIds;
    private String nom;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getCommandesIds() {
        return commandesIds;
    }

    public void setCommandesIds(List<Long> commandesIds) {
        this.commandesIds = commandesIds;
    }
}
