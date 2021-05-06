package com.company;

abstract class Player {

    private String nume;

    public void setNume(String nume){
        this.nume=nume;
    }

    public String getNume(){
        return this.nume;
    }

    public Player(String nume){
        this.nume=nume;
    }

}
