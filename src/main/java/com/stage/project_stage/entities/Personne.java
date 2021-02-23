package com.stage.project_stage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String nomMere;
    private String nomPere;
    private String cin;
    private String sexe;
    private String dateNaissance;
    private String adresse;
    private String etatCivil;

}
