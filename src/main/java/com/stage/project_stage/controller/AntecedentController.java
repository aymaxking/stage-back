package com.stage.project_stage.controller;

import com.stage.project_stage.dao.AntecedentRepository;
import com.stage.project_stage.dao.OperationRepository;
import com.stage.project_stage.dao.SanctionRepository;
import com.stage.project_stage.dao.UtilisateurRepository;
import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Operation;
import com.stage.project_stage.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class AntecedentController {
    @Autowired
    private AntecedentRepository antecedentRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private SanctionRepository sanctionRepository;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    @GetMapping(value="/listAntecedents")
    public List<Antecedent> listAntecedent(){
        return antecedentRepository.findAll();
    }

    @PutMapping(value="/listAntecedents/{eid}/{uid}")
    public void update(@RequestBody Antecedent a,@PathVariable Integer uid,@PathVariable Integer eid){
        a.setId(eid);
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("personne");
        o.setEid(eid);
        o.setUtilisateur(u2);
        o.setTypeOperation("Modification");
        o.setDateOperation(formatter.format(new Date()));
        operationRepository.save(o);
       antecedentRepository.save(a);
    }
    @PostMapping(value="/listAntecedents/{uid}/{pid}")
    public void save(@RequestBody Antecedent a,@PathVariable Integer uid,@PathVariable Integer pid){
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("antecedent");
        o.setUtilisateur(u2);
        o.setTypeOperation("Ajout");
        o.setDateOperation(formatter.format(new Date()));
        a.setPid(pid);
        a.setDateHeureEntecedent(formatter.format(new Date()));
        o.setEid(antecedentRepository.save(a).getId());
        operationRepository.save(o);
    }

    @DeleteMapping(value="/listAntecedents/{eid}/{uid}")
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
        sanctionRepository.deleteSanctionByAidEquals(eid);
        operationRepository.save(o);
        antecedentRepository.deleteById(eid);
    }

}
