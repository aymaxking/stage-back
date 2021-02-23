package com.stage.project_stage.dao;

import com.stage.project_stage.entities.EtatCivil;
import com.stage.project_stage.entities.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
@CrossOrigin("*")
@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne,Integer>{
    @RestResource(path="/byId")
    public Page<Personne> findByIdEquals(@Param("mc") Integer id, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/by")
    public Page<Personne> NomContainsAndPrenomContainsAndCinContainsAndSexeContainsAndEtatCivilContains(@Param("nom")String nom, @Param("prenom")String prenom, @Param("cin")String cin, @Param("sexe")String sexe, @Param("etat")String etatcivil, org.springframework.data.domain.Pageable pageable);
}
