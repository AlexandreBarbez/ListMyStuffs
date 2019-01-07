package org.halx.listMyStuffs.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Stuff {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String description;
    private int quantite;
    private Double prix;

    public Stuff(String nom, String description, int quantite, Double prix) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }
}
