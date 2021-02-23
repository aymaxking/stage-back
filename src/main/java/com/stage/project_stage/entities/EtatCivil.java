package com.stage.project_stage.entities;

public enum EtatCivil {
    CELIBATAIRE("celibataire"),
    MARIE("marie");

    private  final String name;

    EtatCivil(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

}

