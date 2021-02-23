package com.stage.project_stage.entities;

import com.stage.project_stage.dao.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dateOperation;
    private String typeOperation;
    private Integer eid;
    private String etype;
    @ManyToOne
    private Utilisateur utilisateur;
    public Integer getUId(){
        return utilisateur.getId();
    }
    public String getUM(){
        return utilisateur.getMatricule();
    }

}
