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
        this.quantity = quantity;
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

    public void addMedication() {
        Hospital.medications.add(this);
        updateHistory(this.getQuantity());
    }

    public void reduceMedication() {
        if (Hospital.medications.contains(this)) {
            Hospital.medications.remove(this);

            int amount = this.getQuantity();
            amount -= 2 * amount;
            updateHistory(amount);
        }
        else {
            System.out.println("Medication not found");
        }
    }

    public void updateHistory(int amount) {
        history.add(amount);
    }
    
 
}