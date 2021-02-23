package com.stage.project_stage;

import com.stage.project_stage.dao.*;
import com.stage.project_stage.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProjectStageApplication implements CommandLineRunner {

    //Repositorys
    @Autowired
    private PersonneRepository personnerepository;
    @Autowired
    private AntecedentRepository antcedentrepository;
    @Autowired
    private OperationRepository operatrionrepository;
    @Autowired
    private UtilisateurRepository utlisateurrepository;
    @Autowired
    private SanctionRepository sancationrepository;


    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(ProjectStageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       restConfiguration.exposeIdsFor(Personne.class);
        restConfiguration.exposeIdsFor(Antecedent.class);
        restConfiguration.exposeIdsFor(Operation.class);
        restConfiguration.exposeIdsFor(Sanction.class);
        restConfiguration.exposeIdsFor(Utilisateur.class);

//  utlisateurrepository.save(new Utilisateur(null,"consultation","admin1","admin1","M15D86","agentDesDouanesJudiciaires"));
  //   utlisateurrepository.save(new Utilisateur(null,"modification","user1","user1","GA58AD","gendarmerie"));
/*

     operatrionrepository.save(new Operation(null,"15/02/2020 14:15","ajouter"
                ,antcedentrepository.save(new Antecedent(null,"15/02/2019 12:09","15/01/2019","le mdada da dadad ad ","torture"
                ,personnerepository.save(new Personne(null,"khaldi","omar","sara","hamid","AB583","homme","17/11/1992","AV MED 6 IMM 5 APP 7 ","celibataire"))))
                ,utlisateurrepository.getOne(1)));

     operatrionrepository.save(new Operation(null,"16/03/2020 12:13","ajouter"
                ,     antcedentrepository.save(new Antecedent(null,"15/10/2020 15:10","14/02/2020","le mdada da dadad ad ","torture"
                ,personnerepository.save(new Personne(null,"hamidat","prenom","fatima","hamid","AS1370","homme","18/12/1999","AV HASSAN 3 IMM 15 APP 6 ","marie"))))
                ,utlisateurrepository.getOne(1)));

    sancationrepository.save(new Sanction(null,"15","emprisonnement",antcedentrepository.getOne(1)));
    sancationrepository.save(new Sanction(null,"10000","amende",antcedentrepository.getOne(1)));
    sancationrepository.save(new Sanction(null,"5","emprisonnement",antcedentrepository.getOne(2)));
        sancationrepository.save(new Sanction(null,"20000","amende",antcedentrepository.getOne(2)));

*/
 //       for(int i=0;i<60;i++)
//        sancationrepository.save(new Sanction(null,"15","emprisonnement",antcedentrepository.getOne(1)));



//    personnerepository.findAll().forEach(p->{
//         System.out.println(p.toString());
//     });
//     antcedentrepository.findAll().forEach(p->{
//         System.out.println(p.toString());
//     });
//     operatrionrepository.findAll().forEach(p->{
//         System.out.println(p.toString());
//     });
//     utlisateurrepository.findAll().forEach(p->{
//         System.out.println(p.toString());
//     });
//     sancationrepository.findAll().forEach(p->{
//         System.out.println(p.toString());
//     });

    }
}
