package com.spaceSim;

public class SpaceStation extends SpaceObjects {
    //private String orbiting;
    private int profit;
    private String companyOwner;

    public SpaceStation(String name,int capacity,String companyOwner,int population) {
        super(name,capacity,population);
        //this.orbiting = orbiting;
        this.companyOwner = companyOwner;
    }
}
