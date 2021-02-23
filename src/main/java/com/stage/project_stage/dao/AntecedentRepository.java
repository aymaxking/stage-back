package com.stage.project_stage.dao;

import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
public interface AntecedentRepository extends JpaRepository<Antecedent,Integer> {
    @RestResource(path="/byId")
    public Page<Antecedent> findByIdEquals(@Param("mc") Integer id, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/by")
    public Page<Antecedent> findByDateCrimeContainsAndCrimeContainsAndDateHeureEntecedentContains(@Param("datecri") String datecrime,@Param("crime") String crime,@Param("dateant") String dateheureantecedent, org.springframework.data.domain.Pageable pageable);
    @RestResource(path="/byPid")
    public Page<Antecedent> findByPidEquals(@Param("mc") Integer PID, org.springframework.data.domain.Pageable pageable);
    public void deleteAntecedentByPidEquals(Integer id);
}
