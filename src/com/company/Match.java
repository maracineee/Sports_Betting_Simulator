package com.company;


import java.util.Random;

public class Match {
        Random random=new Random();
        private Team team1;
        private Team team2;
        private int score1;
        private int score2;
        private double cota;


        public Match() {
        }

        public Match(Team team1, Team team2){
            this.team1=team1;
            this.team2=team2;
            float cota=random.nextFloat();
            this.cota=cota;
        }

        public Match(Team team1, Team team2, int sc1, int sc2, double cota){
            this.team1=team1;
            this.team2=team2;
            score1=sc1;
            score2=sc2;
            this.cota=cota;
        }

    public Match(Team team1, Team team2, int sc1, int sc2){
        this.team1=team1;
        this.team2=team2;
        score1=sc1;
        score2=sc2;
        float cota2=random.nextFloat();
        this.cota=cota2;
    }

        public Team getTeam1() {
            return team1;
        }

        public void setTeam1(Team team1) {
            this.team1 = team1;
        }

        public Team getTeam2() {
            return team2;
        }

        public void setTeam2(Team team2) {
            this.team2 = team2;
        }

        public int getScore1() {
            return score1;
        }

        public int getScore2() {
            return score2;
        }

        public double getCota() {
            return cota;
        }

        public void setCota(double cota) {
            this.cota = cota;
        }

        @Override
        public String toString() {
            return "Match{" +
                    "team1=" + team1.getName() +
                    ", score1=" +score1+
                    ", team2=" + team2.getName()+
                    ", team2=" + score2+
                    ", cota=" + cota +
                    '}';
        }



        public String toSave() {
            String mes = "";
            mes = mes + team1.getName();
            mes = mes + ",";
            mes = mes + team2.getName();
            mes = mes + ",";
            mes = mes + getScore1();
            mes = mes + ",";
            mes = mes + getScore2();
            mes = mes + ",";
            mes = mes + cota;
            mes = mes + "\n";

            return mes;
        }
    }



