package com.stage.project_stage.entities;

import com.stage.project_stage.dao.PersonneRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Antecedent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dateHeureEntecedent;
    private String dateCrime;
    private String description;
    private String crime;
    private Integer pid;
    @ManyToOne
    private Personne personne;

    public Antecedent(Integer id, String dateHeureEntecedent, String dateCrime, String description, String crime, Personne personne) {
        this.id = id;
        this.dateHeureEntecedent = dateHeureEntecedent;
        this.dateCrime = dateCrime;
        this.description = description;
        this.crime = crime;
        this.personne = personne;
        this.pid=personne.getId();
    }

//    public Integer getPID(){
//        return personne.getId();
//    }
}
