package edu.ithaca.barr.meds;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hospital {
    
    ArrayList<Medication> medications;

    public Hospital() {
        this.medications = new ArrayList();
    }


public ArrayList<Medication> getMedications(){
    throw new UnsupportedOperationException("Not implemented yet.");
}

public Medication searchMedication(int id){
    throw new UnsupportedOperationException("Not implemented yet.");
}

}