package edu.ithaca.barr.meds;

import java.util.HashMap;

public class Doctor {
    
    String email;
    String password;

    public Doctor(String email, String password){
        this.email = email;
        this.password = password;
    }


    Hospital hospital = new Hospital();

    public void addMedication(String name , int id , double dosage, int frequency){
        Medication medication = new Medication(name,id,dosage,frequency);
        hospital.medications.add(medication);
    }

    public void deleteMedication(int medId){
       if(hospital.searchMedication(medId)!= null)
            hospital.getMedications().removeIf(med -> med.getId()==medId);
       else
            throw new IllegalArgumentException("A medication with this ID does not exist");        
    }

   
    //deletes the medication with the indicated Id and creates another one with the same id
    public void updateMedication(String name, int id, double dosage, int frequency){
        deleteMedication(id);
        addMedication(name, id, dosage, frequency);

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
public void prescribeMedication(int patientId, int medicationId, double dosage, int frequency) {
    Medication medication = hospital.searchMedication(medicationId);
    //Patient patient = hospital.searchPatient(patientId);

    if (medication == null) {
        throw new IllegalArgumentException("Invalid medication ID.");
    }

    /*if (patient == null) {
        throw new IllegalArgumentException("Patient not found.");
    }*/

    HashMap<String, Object> prescription = new HashMap<String, Object>();
    prescription.put("medication", medication);
   // prescription.put("patient", patient);
    prescription.put("dosage", dosage);
    prescription.put("frequency", frequency);

    //hospital.addToPrescriptionList(prescription);
}
}