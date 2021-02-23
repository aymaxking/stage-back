package com.stage.project_stage.projections;

import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Personne;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Antecedent.class)  // http://localhost:8080/antecedents?projection=P1
public interface AntecedentProjection {
    public Integer getId();
    public String getDateHeureEntecedent();
    public String getDateCrime();
    public String getDescription();
    public Integer getPersonneCin();
}
