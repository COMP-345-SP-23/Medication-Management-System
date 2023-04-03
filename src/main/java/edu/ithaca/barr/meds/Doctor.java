package edu.ithaca.barr.meds;

public class Doctor {
    
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
}
