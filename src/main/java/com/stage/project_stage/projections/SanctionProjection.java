package com.stage.project_stage.projections;

import com.stage.project_stage.entities.GenreSanction;
import com.stage.project_stage.entities.Personne;
import com.stage.project_stage.entities.Sanction;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Sanction.class)  // http://localhost:8080/personnes?projection=P1
public interface SanctionProjection {
    public Integer getId();
    public int getNombre();
    public String getGenreSanction();
    public Integer getAntecedentId();
}
