package com.spaceSim;

import java.util.List;
import java.util.Scanner;

public class Planet extends SpaceObjects {
    private java.util.List list = new java.util.ArrayList();
    private Object SpaceStation;

    public Planet(String name, int capacity, int population) {
        super(name,capacity,population);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void planetInfo(Scanner input, Company company) {
        System.out.println("Planet: " + this.getName());
        System.out.println("Population: " + this.getPopulation());
        System.out.println("Capacity: " + this.capacity);
        System.out.println("");
        while (true) {
            System.out.println("1: View Space Stations");
            System.out.println("2: Build a Space Station");
            System.out.println("3: Back");
            int choice = input.nextInt();
            if (choice == 1) {
                for (Object s:list){
                    if(s.getClass() == SpaceStation){
                        //s.getName()
                    }
                }
            } else if (choice == 2) {
                System.out.println("It will cost "+ 100+100*company.getInfluence()+"credits, are you sure? y/n");
                String buyChoice = input.nextLine();
                if (buyChoice.toLowerCase().equals("y")){
                    company.setMoney(company.getMoney()-(100+100*company.getInfluence()));
                }
            } else {
                break;
            }
        }
    }

}
