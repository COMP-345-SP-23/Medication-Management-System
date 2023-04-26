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

    public void addMedication(Medication med) {
        Hospital.medications.add(med);
        med.updateHistory(med.getQuantity());
    }

    public void reduceMedication(Medication med) {
        if (Hospital.medications.contains(med)) {
            Hospital.medications.remove(med);

            int amount = med.getQuantity();
            amount -= 2 * amount;
            med.updateHistory(amount);
        }
        else {
            System.out.println("Medication not found");
        }
    }

    public void updateHistory(int amount) {
        history.add(amount);
    }
    
 
}