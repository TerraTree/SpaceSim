package com.spaceSim;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> tempPlanets = webScrape();
        ArrayList<Company> companies = new ArrayList<Company>();
        Company playerCompany = new Company("PlayerCompany",100,0);
        companies.add(playerCompany);
        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Earth",10000000,7800000));
        for (Company c:companies) {
            planets.get(0).getSpaceStations().add(new SpaceStation(c.getName()+"'s Station",30,c.getName(),5));
        }
        while (true){
            int index =0;
            for (Company p: companies){
                if (index == 0){
                    p.playerTurn(planets);
                }
                else{
                    p.aiTurn();
                }
                index++;
            }
            endTurn(planets,companies);
            //System.out.println(planets.get(0).getSpaceStations().size());
            System.out.println("end turn");
        }
    }

    private static void endTurn(ArrayList<Planet> planets, ArrayList<Company> companies) {
    for(Planet p:planets){
        System.out.println("new stations: " + p.counters.size());
        for (int i=p.tempStations.size()-1;i<0;i--){
            int timeLeft = p.counters.get(i);
            System.out.println(timeLeft);
            if(timeLeft == 0){
                System.out.println(p.tempStations.get(i).population);
                p.getSpaceStations().add(p.tempStations.get(i));
                p.tempStations.remove(i);
            }
            else{
                timeLeft--;
            }
        }
    }
    }

    public static ArrayList<String> webScrape() {
        final String url = "http://enneadgames.com/generators/planet-name-generator/";
        try {
            final Document document = Jsoup.connect(url).get();
            Elements name = document.getElementsByClass("column-2");
            name.remove(0);
            name.remove(name.size() - 1);
            name.remove(name.size() - 1);
            ArrayList<String> tempScraped = new ArrayList<String>();
            for (Element e : name) {
                String temp = e.toString();
                temp = temp.substring(temp.indexOf(">") + 1, temp.indexOf("/") - 1);
                tempScraped.add(temp);
            }
            return (tempScraped);
        } catch (Exception e) {
            e.printStackTrace();
            ArrayList<String> blank = new ArrayList<String>();
            return blank;
        }
    }

    public static int objectDialogue(ArrayList<String> spaceNames){
        Scanner input = new Scanner(System.in);
        int page=0;
        int counter=1;
        boolean running = true;
        System.out.println(spaceNames.size());
        while (running) {
            for (int i = page * 8; i < spaceNames.size(); i++) {
                if (counter == 9) {
                    break;
                } else {
                    System.out.println(counter + ": " + spaceNames.get(i));
                    counter++;
                }
            }
            if (counter ==9) {
                System.out.println("9: Next Page");
            }
            System.out.println("0: Back");
            int choice = input.nextInt();
            if (choice == 9 && counter==9){
                page++;
                counter=1;
            }
            else if (choice == 0){
                return 0;
            }
            else if (choice > 0 && choice < counter){
                System.out.println("counter: "+counter);
                int index = choice + page*counter;
                return index;
            }
            else{
                counter--;
            }
        }
        return 0;
    }

    public static int menuDialogue(String textFile, String marker){
        int choice;
        int entries = 1;
        try {
            File text = new File(textFile);
            Scanner typed = new Scanner(System.in);
            Scanner myReader = new Scanner(text);
            boolean found = false;
            String data = "";
            boolean done = false;
            while(myReader.hasNextLine() && !done){
                data = myReader.nextLine();
                if (found) {
                    if (data.equals("")) {
                        done=true;
                    }
                    else {
                        System.out.println(entries+": "+data);
                        entries++;
                        //input.nextLine();
                    }
                }
                if(data.equals(marker)){
                    found = true;
                }
            }
            myReader.close();
            while (true){
                choice = typed.nextInt();
                if (choice >=1 && choice <entries){
                    return choice;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}