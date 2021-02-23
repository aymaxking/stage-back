package com.stage.project_stage.projections;

import com.stage.project_stage.entities.Personne;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Personne.class)  // http://localhost:8080/personnes?projection=P1
public interface PersonneProjection {
    public String getAdresse();
    public String getetat_civil();
}
