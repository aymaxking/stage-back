package com.stage.project_stage.dao;

import com.stage.project_stage.entities.Operation;
import com.stage.project_stage.entities.Personne;
import com.stage.project_stage.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin("*")
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @RestResource(path="/byId")
    public Page<Utilisateur> findByIdEquals(@Param("mc") Integer id, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/by")
    public Page<Utilisateur> findByTypeContainsAndMatriculeContains(@Param("type") String type,@Param("matricule") String matricule, org.springframework.data.domain.Pageable pageable);
}
