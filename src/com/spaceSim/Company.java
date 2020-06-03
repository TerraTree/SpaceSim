package com.spaceSim;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void viewPlanets(ArrayList<Planet> planets, Scanner input){
        int page=0;
        int counter=1;
        boolean running = true;
        System.out.println(planets.size());
        while (running) {
            for (int i = 0; i < planets.size(); i++) {
                if (counter == 9) {
                    break;
                }
                System.out.println("1: "+ planets.get(i).getName());
                counter++;
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
                    running = false;
                }
                else if (choice > 0 && choice <= counter){
                    System.out.println();
                    planets.get(choice+page*counter -1).planetInfo(this);
                }
        }
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
                    this.viewPlanets(planets, input);
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
