package com.spaceSim;

import java.util.ArrayList;
import java.util.Scanner;
import static com.spaceSim.Main.menuDialogue;
import static com.spaceSim.Main.objectDialogue;


public class Planet extends SpaceObjects {
    private ArrayList<SpaceStation> spaceStations = new ArrayList<SpaceStation>();
    ArrayList<SpaceObjects> tempStations = new ArrayList<>();
    ArrayList<Integer> counters = new ArrayList<>();

    public Planet(String name, int capacity, int population) {
        super(name,capacity,population);
    }

    public ArrayList getSpaceStations() {
        return spaceStations;
    }

    public void setSpaceStations(ArrayList spaceStations) {
        this.spaceStations = spaceStations;
    }

    public void planetInfo(Company company) {
        Scanner input = new Scanner(System.in);
        System.out.println("Planet: " + this.getName());
        System.out.println("Population: " + this.getPopulation());
        System.out.println("Capacity: " + this.capacity);
        System.out.println("");
        while (true) {
            int choice = menuDialogue("menu.txt", "2");
            if (choice == 1) {
                ArrayList<String> names = new ArrayList<>();
                for (SpaceStation ss : spaceStations) {
                    names.add(ss.getName());
                }
                int index = objectDialogue(names);
                if (index != -1) {
                    SpaceStation s = spaceStations.get(index);
                    System.out.println("Name: " + s.getName());
                    System.out.println("Population: " + s.getPopulation());
                    System.out.println("Capacity: " + s.getCapacity());
                    choice = menuDialogue("menu.txt", "3");
                    if (choice == 1) {
                        System.out.println("It will cost " + 40 + 40 * company.getInfluence() + "credits, are you sure? y/n");
                        String buyChoice = input.nextLine();
                        if (buyChoice.toLowerCase().equals("y")) {
                            company.setMoney(company.getMoney() - (40 + 40 * company.getInfluence()));
                        }
                    }
                }
            } else if (choice == 2) {
                System.out.println("It will cost " + 100 + 100 * company.getInfluence() + "credits, are you sure? y/n");
                String buyChoice = input.nextLine();
                if (buyChoice.toLowerCase().equals("y")) {
                    company.setMoney(company.getMoney() - (100 + 100 * company.getInfluence()));
                    this.tempStations.add(new SpaceStation("new Station", 10, company.getName(), 3));
                    this.counters.add(0);
                    System.out.println("building space station");
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}
