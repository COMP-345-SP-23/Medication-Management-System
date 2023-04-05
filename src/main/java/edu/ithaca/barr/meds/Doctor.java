package edu.ithaca.barr.meds;

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
}
