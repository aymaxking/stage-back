package com.stage.project_stage.dao;

import com.stage.project_stage.entities.Operation;
import com.stage.project_stage.entities.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.util.List;
@CrossOrigin("*")
public interface OperationRepository extends JpaRepository<Operation,Integer> {
    @RestResource(path="/byId")
    public Page<Operation> findByIdEquals(@Param("mc") Integer id, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/by")
    public Page<Operation> findByDateOperationContainsAndTypeOperationContainsAndEtypeContains(@Param("date") String date,@Param("type") String type,@Param("etype") String etype, org.springframework.data.domain.Pageable pageable);

}
