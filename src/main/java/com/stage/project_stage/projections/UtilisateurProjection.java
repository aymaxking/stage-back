package com.stage.project_stage.projections;

import com.stage.project_stage.entities.Utilisateur;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="P1" ,types= Utilisateur.class)
public interface UtilisateurProjection {

}
