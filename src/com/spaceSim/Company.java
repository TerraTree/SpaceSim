package com.spaceSim;

import java.util.ArrayList;
import java.util.Scanner;

import static com.spaceSim.Main.objectDialogue;

public class Company {
    private String name;
    private int money;
    private int influence;
    private ArrayList holdings;

    public Company(String name, int money, int influence) {
        this.name = name;
        this.money = money;
        this.influence = influence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public void viewCompanyStats(){

    }

    public void playerTurn(ArrayList<Planet> planets) {
        int index = 1;
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1: View Planets");
            System.out.println("2: Explore New Planets");
            System.out.println("3: Statistics");
            System.out.println("4: End Turn");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    ArrayList<String> names = new ArrayList<>();
                    for (Planet p:planets){
                        names.add(p.getName());
                    }
                    int index2 = objectDialogue(names);
                    if (index2 != -1){
                        planets.get(index2).planetInfo(this);
                    }
                    break;
                case 2:

                    break;
                case 3:
                    this.viewCompanyStats();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    public void aiTurn(){

    }
}
