package edu.ithaca.barr.meds;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hospital {
    
    ArrayList<Medication> medications;

    public Hospital() {
        this.medications = new ArrayList();
    }


public ArrayList<Medication> getMedications(){
    return medications;
}

public Medication searchMedication(int id){
    Medication result= null; 
    for(Medication medication : medications ){

        if (medication.getId() == id){
        result = medication;
        break;
        }
}
return result;
}

}