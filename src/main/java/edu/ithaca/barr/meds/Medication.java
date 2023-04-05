package edu.ithaca.barr.meds;

public class Medication {
    
    private String name;
    private int id;
    private double dosage;
    private int frequency;
    
    public Medication(String name, int id, double dosage, int frequency){
        this.name = name;
        this.id = id;
        this.dosage = dosage;
        this.frequency = frequency;
    }

    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    public double getDosage(){
        return dosage;
    }

    public int getFrequency(){
        return frequency;
    }
}