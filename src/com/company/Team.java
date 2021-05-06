package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Team<T extends Player> {
    private String name;
    private int played;
    private int tied;
    private int lost;
    private int won;
    private int rank;
    private int score;
    private Lista<T> playeri=new Lista<>();
    private ArrayList<Match> meciuri=new ArrayList<>();


    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(T player){
        this.playeri.addLast(player);
    }

    public int getPlayed(){
        return this.played;
    }

    public int getTied(){
        return this.tied;
    }

    public int getLost(){
        return this.lost;
    }

    public int getWon(){
        return this.won;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Match> getMeciuri() {
        return meciuri;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getRank(){
        return 3* this.rank+tied;
    }

    public void setScore(int score){
        this.score=score;
    }

    public void addMatch(Match match){
        meciuri.add(match);
    }

    public void afisareMeciuri(){
        for(int i=0;i<meciuri.size();i++)
            System.out.println(meciuri.get(i));
    }

    public int getScore(){
        return score;
    }










}

