package edu.ithaca.barr.meds;

import java.util.ArrayList;

public class Medication {
    
    private String name;
    private int id;
    private int quantity;
    ArrayList<Integer> history;
   
    
    
    public Medication(String name, int id, int quantity){
        this.name = name;
        this.id = id;
        this.quantity = 0;
        this.history = new ArrayList<>();
       
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

    public void addMedication(int amount) {
        this.quantity += amount;
        updateHistory(amount);
    }

    public void reduceMedication(int amount) {
        if (amount <= this.quantity) {
            this.quantity -= amount;
            int negativeAmount = amount - (2*amount);
            updateHistory(negativeAmount);
        }
        else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    public void updateHistory(int amount) {
        history.add(amount);
    }
    
 
}