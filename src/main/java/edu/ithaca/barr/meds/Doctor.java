package edu.ithaca.barr.meds;

import java.util.ArrayList;
import java.util.HashMap;

public class Doctor {
    Hospital hospital = new Hospital();
    String email;
    String password;

    
    public Doctor(String email, String password,Hospital hospital){
        this.email = email;
        this.password = password;
        this.hospital = hospital;
          
    }


    

    public void addMedication(String name ){
        hospital.addToMedications(name);
    
    }

    public void deleteMedication(int medId){
       if(hospital.searchMedication(medId)!= null)
            hospital.getMedications().removeIf(med -> med.getId()==medId);
       else
            throw new IllegalArgumentException("A medication with this ID does not exist");        
    }

   
    //deletes the medication with the indicated Id and creates another one with the same id
  
    public void updateMedication(String name, int id){
        deleteMedication(id);
        addMedication(name);
        addMedication(name);

    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }


/*  Methods that should be written in the hospital class for this method to work :
    *searchPatient method that searchs a patient from the list of all patients should 
    *addToPrescriptionList that adds all the prescribed medications to an arraylist

*/
public void prescribeMedication(int patientId, int medicationId, double dosage, int frequency,int totalAmount,int amountPerDay) {
    Medication medication = hospital.searchMedication(medicationId);
    Patient patient = hospital.searchPatient(patientId);

    HashMap<String, Object> prescription = new HashMap<String, Object>();

    if (medication == null) {
        throw new IllegalArgumentException("Invalid medication ID.");
    }

    
    if (patient == null) {
        throw new IllegalArgumentException("Patient not found.");
    }
    
    if(hospital.searchMedicationForPatient(medicationId, patientId)==null){
       
        prescription.put("medication", medication);
        prescription.put("patient", patient);
        prescription.put("dosage", dosage);
        prescription.put("frequency", frequency);
        prescription.put("TotalAmount",totalAmount);
        prescription.put("amountPerDay",amountPerDay);
        hospital.addToPrescriptionList(prescription);}

    
    // else{
    //     HashMap<String, Object> prescribed = hospital.searchMedicationForPatient(medicationId,patientId);
    //     if(prescribed.get("TotalAmount")==0){
    //     prescribed.put("TotalAmount",prescribed.get("TotalAmount") + totalAmount);
    //     prescribed.put("amountPerDay",amountPerDay);}
    //     else
    //         throw new IllegalArgumentException("The patient is already taking the medication");
    // }


}
}