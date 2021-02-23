package com.stage.project_stage.controller;

import com.stage.project_stage.dao.AntecedentRepository;
import com.stage.project_stage.dao.OperationRepository;
import com.stage.project_stage.dao.PersonneRepository;
import com.stage.project_stage.dao.UtilisateurRepository;
import com.stage.project_stage.entities.Antecedent;
import com.stage.project_stage.entities.Operation;
import com.stage.project_stage.entities.Personne;
import com.stage.project_stage.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class PersonneController {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AntecedentRepository antecedentRepository;


    @GetMapping(value="/listPersonnes")
    public List<Personne> listPersonnes(){
        return personneRepository.findAll();
    }
    @PutMapping(value="/listPersonnes/{eid}/{uid}")
    void update(@RequestBody Personne p,@PathVariable Integer uid,@PathVariable Integer eid){
        p.setId(eid);
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("Personne");
        o.setEid(eid);
        o.setUtilisateur(u2);
        o.setTypeOperation("Modification");
        o.setDateOperation(formatter.format(new Date()));
        operationRepository.save(o);
        personneRepository.save(p);
    }
    @PostMapping(value="/listPersonnes/{uid}")
      void save(@RequestBody Personne p,@PathVariable Integer uid){
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("Personne");
        o.setUtilisateur(u2);
        o.setTypeOperation("Ajout");
        o.setDateOperation(formatter.format(new Date()));
        o.setEid(personneRepository.save(p).getId());
        operationRepository.save(o);
    }
    @DeleteMapping(value="/listPersonnes/{eid}/{uid}")
    void delete(@PathVariable Integer eid,@PathVariable Integer uid){
        Operation o = new Operation();
        Optional<Utilisateur> u = utilisateurRepository.findById(uid);
        Utilisateur u2 = new Utilisateur();
        u2.copy(u);
        o.setEtype("Personne");
        o.setUtilisateur(u2);
        o.setTypeOperation("Supression");
        o.setDateOperation(formatter.format(new Date()));
        o.setEid(-1);
        antecedentRepository.deleteAntecedentByPidEquals(eid);
        operationRepository.save(o);
        personneRepository.deleteById(eid);
    }
}
