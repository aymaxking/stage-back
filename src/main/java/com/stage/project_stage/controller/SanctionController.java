package com.stage.project_stage.controller;

import com.stage.project_stage.dao.AntecedentRepository;
import com.stage.project_stage.dao.OperationRepository;
import com.stage.project_stage.dao.SanctionRepository;
import com.stage.project_stage.dao.UtilisateurRepository;
import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Operation;
import com.stage.project_stage.entities.Sanction;
import com.stage.project_stage.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class SanctionController {
    @Autowired
    private AntecedentRepository antecedentRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private SanctionRepository sanctionRepository;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    @GetMapping(value="/listSanctions")
    public List<Sanction> listAntecedent(){
        return sanctionRepository.findAll();
    }

    @PutMapping(value="/listSanctions/{eid}/{uid}")
    public void update(@RequestBody Sanction s, @PathVariable Integer uid, @PathVariable Integer eid){
        s.setId(eid);
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("sanction");
        o.setEid(eid);
        o.setUtilisateur(u2);
        o.setTypeOperation("Modification");
        o.setDateOperation(formatter.format(new Date()));
        operationRepository.save(o);
        sanctionRepository.save(s);
    }
    @PostMapping(value="/listSanctions/{uid}/{aid}")
    public void save(@RequestBody Sanction s,@PathVariable Integer uid,@PathVariable Integer aid){
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("sanction");
        o.setUtilisateur(u2);
        o.setTypeOperation("Ajout");
        o.setDateOperation(formatter.format(new Date()));
        s.setAid(aid);
        o.setEid(sanctionRepository.save(s).getId());
        operationRepository.save(o);
    }

    @DeleteMapping(value="/listSanctions/{eid}/{uid}")
    void delete(@PathVariable Integer eid,@PathVariable Integer uid){
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("Antecedent");
        o.setUtilisateur(u2);
        o.setTypeOperation("Supression");
        o.setDateOperation(formatter.format(new Date()));
        o.setEid(-1);
        operationRepository.save(o);
        sanctionRepository.deleteById(eid);
    }

}
