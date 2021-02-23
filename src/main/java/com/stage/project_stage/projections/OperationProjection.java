package com.stage.project_stage.projections;

import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Operation;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Operation.class)  // http://localhost:8080/antecedents?projection=P1
public interface OperationProjection {
    public Integer getId();
    public String getDateOperation();
    public String getTypeOperation();
    public Integer getUId();
    public Integer getAId();
}
