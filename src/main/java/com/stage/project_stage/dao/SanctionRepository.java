package com.stage.project_stage.dao;

import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Personne;
import com.stage.project_stage.entities.Sanction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
public interface SanctionRepository extends JpaRepository<Sanction,Integer> {
    @RestResource(path="/byId")
    public Page<Sanction> findByIdEquals(@Param("mc") Integer id, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/by")
    public Page<Sanction> findBygenreSanctionContainsAndNombreContains(@Param("genre") String genresanction,@Param("nombre") String nombre, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/byAid")
    public Page<Sanction> findByAidEquals(@Param("mc") Integer aid, org.springframework.data.domain.Pageable pageable);
    public void deleteSanctionByAidEquals(Integer id);
}
