package com.spaceSim;

public class SpaceObjects {
    protected String name;
    protected int capacity;
    protected int population;
    protected int growth;


    public SpaceObjects(String name, int capacity, int population) {
        this.name = name;
        this.capacity = capacity;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }
}
