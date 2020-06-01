package com.spaceSim;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> tempPlanets = webScrape();
        ArrayList<Company> companies = new ArrayList<Company>();
        Company playerCompany = new Company("PlayerCompany",100,0);
        companies.add(playerCompany);
        ArrayList<Planet> planets = new ArrayList<Planet>();
        planets.add(new Planet("Earth",10000000,7800000));
        for (Company c:companies) {
            planets.get(0).getList().add(new SpaceStation(c.getName()+"'s Station",30,c.getName(),5));
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
}