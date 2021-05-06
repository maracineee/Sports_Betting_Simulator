package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class League<U extends Player,T extends Team<U>> {
    private Lista<T> echipe = new Lista<>();
    private Lista<Match> meciuri = new Lista<>();

    public League()  {
        try {
            importEchipa();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void adaugareEchipa(T echipa) {
        echipe.addLast(echipa);
    }

    public Lista<T> getEchipe() {
        return echipe;
    }

    public Lista<Match> getMeciuri() {
        return meciuri;
    }

    public void stergereEchipa(String nume) {
        for (int i = 0; i < echipe.size(); i++)
            if (echipe.getPosition(i).getData().getName().equals(nume))
                echipe.removePosition(i);

    }


    public void updateEchipe(String nume1, String nume2) {

        int j = 0;
        while (echipe.getPosition(j).getData().getName() != nume2)
            j++;
        T teamN = echipe.getPosition(j).getData();
        for (int i = 0; i < echipe.size(); i++)
            if (echipe.getPosition(i).getData().getName().equals(nume1))
                echipe.getPosition(i).setData(teamN);
    }

    public void sortareEchipe() {
        int fl = 0;
        do {
            fl = 0;
            for (int i = 0; i < echipe.size() - 1; i++) {
                if (echipe.getPosition(i).getData().getRank() > echipe.getPosition(i + 1).getData().getRank()) {
                    T aux = echipe.getPosition(i).getData();
                    echipe.getPosition(i).setData(echipe.getPosition(i + 1).getData());
                    echipe.getPosition(i + 1).setData(aux);
                    fl = 1;
                }
            }

        } while (fl == 1);


    }

    public void afisareEchipe() {
        for (int i = 0; i < echipe.size(); i++)
            System.out.println(echipe.getPosition(i).getData().getName());
    }

    public Team getATeam(String name) {
        int i = 0;
        while (echipe.getPosition(i).getData().getName().equals(name) == false)
            i++;
        return echipe.getPosition(i).getData();
    }


    public void afisareMeciuriLiga(){
        for(int i=0;i<meciuri.size();i++)
            System.out.println(meciuri.getPosition(i).getData());
    }

    public void addTeamsFile() {
        try {
            File file = new File("src/com/company/echipe.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter print = new PrintWriter(fw);
            print.println(this.toSave());
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toSave() {
        String echipee = "";
        for (int i = 0; i < echipe.size(); i++) {
            echipee = echipee + echipe.getPosition(i).getData().getName();
            echipee = echipee + "\n";
        }
        return echipee;
    }

    public String toSaveMeci() {
        String mes = "";
        for (int i = 0; i < meciuri.size(); i++) {
            mes = mes + meciuri.getPosition(i).getData().toSave();
        }
        return mes;
    }

    public void addMatchesFile() {
        try {
            File file = new File("src/com/company/meciuri.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter print = new PrintWriter(fw);
            print.println(this.toSaveMeci());
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adaugareMeci(Match mecii){
        meciuri.addLast(mecii);
    }

    public void importEchipa() throws FileNotFoundException {
        try {
            File file = new File("src/com/company/echipe.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] prop = scanner.nextLine().split(",");
                echipe.addLast((T) new Team(prop[0]));
            }
        } catch (Exception e) {
            System.out.println("Nu s a gasit fisierul");
        }
    }


    public void importMeciuri() throws FileNotFoundException {
        try {
            File file = new File("src/com/company/meciuri.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] prop = scanner.nextLine().split(",");
                Match meci=new Match(getATeam(prop[0]), getATeam(prop[1]), Integer.parseInt(prop[2]), Integer.parseInt(prop[3]), Double.parseDouble(prop[4]));
                meciuri.addLast(meci);
                getATeam(prop[0]).addMatch(meci);
                getATeam(prop[1]).addMatch(meci);
            }
        } catch (Exception e) {
            System.out.println("Nu s a gasit fisierulImportMeciuri");
        }
    }

    public void pariaza(Team team1, Team team2, double sumaPariata) {
        Random random = new Random();
        int randomScore1=random.nextInt(5);
        int randomScore2=random.nextInt(5);
        Match meci = new Match(team1, team2,randomScore1,randomScore2);
        double cota = meci.getCota();
        System.out.println("Cota este de:" + cota);
        if (randomScore1 > randomScore2) {
            System.out.println("Ati castigat cu scorul de: " + randomScore1 + ":" + randomScore2);
        } else if (randomScore1 < randomScore2 || randomScore1 == randomScore2) {
            System.out.println("Ati pierdut cu scorul de: " + randomScore1 + ":" + randomScore2);
        }

        meciuri.addLast(meci);
        addMatchesFile();
    }

    public void meniu() throws FileNotFoundException {
        this.importMeciuri();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buna ziua! Introduceti numele echipei pe care pariati:");
        System.out.println("Echipele disponibile sunt:");
        for (int j = 0; j < echipe.size(); j++)
            System.out.println(echipe.getPosition(j).getData());
        String e1 = scanner.nextLine();
        Team echipa1 = getATeam(e1);


        System.out.println("Doriti sa vedeti ultimele meciuri ale echipei dvs?");
        String optiune=scanner.nextLine();
        if(optiune.equals("da") || optiune.equals("Da")) {
            if (echipa1.getMeciuri().size() <= 10) {
                echipa1.afisareMeciuri();
            } else
                for (int i = 0; i < 10; i++)
                    System.out.println(echipa1.getMeciuri().get(i));
        }


        System.out.println("Introduceti numele echipei adversare:");
        System.out.println("Echipele disponibile sunt:");

        for (int j = 0; j < echipe.size(); j++)
            System.out.println(echipe.getPosition(j).getData());
        String e2 = scanner.nextLine();
        System.out.println("Introduceti suma de bani pe care doriti sa o pariati:");
        double suma = Double.parseDouble(scanner.nextLine());
        Team echipa2 = getATeam(e2);
        pariaza(echipa1, echipa2, suma);

    }


}
