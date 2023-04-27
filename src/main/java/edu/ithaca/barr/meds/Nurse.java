package edu.ithaca.barr.meds;

import java.util.HashMap;

public class Nurse {
    Hospital hospital = new Hospital();

    public Nurse(Hospital hospital){
        this.hospital = hospital;
    }

    public void medicationTaken(int medId,int quantity, int patientId){
    HashMap<String, Object> prescription = hospital.searchMedicationForPatient(medId, patientId);
    
    if (prescription == null) {
        throw new IllegalArgumentException("This medication is not assigned for this patient");
    }
    
    int newAmount = (int) prescription.get("TotalAmount") - quantity;
    if (newAmount < 0) {
        throw new IllegalArgumentException("The patient has taken more medication than prescribed");
    }

    prescription.put("TotalAmount", newAmount);

    if ((int) prescription.get("amountPerDay") != quantity) {
        hospital.searchPatient(patientId).setNotTakenProperly(true);
    }
    if ((int)prescription.get("TotalAmount") == 0) {
        hospital.searchPatient(patientId).setFinishedPrescription(true);
    }
}
}
