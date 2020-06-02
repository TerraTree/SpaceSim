package com.spaceSim;

import java.util.ArrayList;
import java.util.Scanner;
import static com.spaceSim.Main.menuDialogue;


public class Planet extends SpaceObjects {
    private ArrayList spaceStations = new ArrayList();
    //private Object SpaceStation;

    public Planet(String name, int capacity, int population) {
        super(name,capacity,population);
    }

    public ArrayList getSpaceStations() {
        return spaceStations;
    }

    public void setSpaceStations(ArrayList spaceStations) {
        this.spaceStations = spaceStations;
    }

    public void planetInfo(Scanner input, Company company) {
        System.out.println("Planet: " + this.getName());
        System.out.println("Population: " + this.getPopulation());
        System.out.println("Capacity: " + this.capacity);
        System.out.println("");
        while (true) {
            int choice = menuDialogue("menu.txt","2");
            if (choice == 1) {
                for (var s:spaceStations){
                    if(1==1){
                        //s.getName()
                    }
                }
            } else if (choice == 2) {
                System.out.println("It will cost "+ 100+100*company.getInfluence()+"credits, are you sure? y/n");
                String buyChoice = input.nextLine();
                if (buyChoice.toLowerCase().equals("y")){
                    company.setMoney(company.getMoney()-(100+100*company.getInfluence()));
                }
            } else if (choice == 3) {
                break;
            }
        }
    }

}
