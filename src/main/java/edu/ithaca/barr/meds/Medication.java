package edu.ithaca.barr.meds;

import java.util.ArrayList;

public class Medication {
    
    private String name;
    private int id;
    private int quantity;
    ArrayList<Integer> history;
   
    
    
    public Medication(String name, int id, int quantity, ArrayList<Integer> history){
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.history = history;
       
    }

    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public ArrayList<Integer> getHistory() {
        return history;
    }

    public void addMedication() {

    }

    public void reduceMedication() {

    }

    public void updateHistory(int amount) {

    }
    
 
}