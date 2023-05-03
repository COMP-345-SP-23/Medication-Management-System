package edu.ithaca.barr.meds;


import java.util.ArrayList;
import java.util.HashMap;




public class Hospital {

    // ArrayList to store Medication objects
    static ArrayList<Medication> medications;

    // ArrayList to store prescription information as HashMap objects
    ArrayList<HashMap<String, Object>> prescriptionList;

    // ArrayList to store Patient objects
    ArrayList<Patient> patients;

    // Constructor to initialize the ArrayLists
    public Hospital() {
        medications = new ArrayList<Medication>();
        this.prescriptionList = new ArrayList<HashMap<String, Object>>();
        this.patients = new ArrayList<Patient>();
    }

    // Method to get the list of Medication objects
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    // Method to get the list of Patient objects
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    // Method to get the list of prescribed Medication information as HashMap objects
    public ArrayList<HashMap<String, Object>> getPrescribedMedications() {
        ArrayList<HashMap<String, Object>> prescribedMedications = new ArrayList<HashMap<String, Object>>();

        for (HashMap<String, Object> prescription : prescriptionList) {
            prescribedMedications.add(prescription);
        }

        return prescribedMedications;
    }

    // Method to add Medication to the list of Medication objects
    public void addToMedications(String name, int quantity ) {
        int id = medications.size() + 1;
        Medication medication = new Medication(name, id,quantity);
        medications.add(medication);
        medication.addMedication(quantity);
    }

    // Method to search for a Medication by its id
    public Medication searchMedication(int id) {
        Medication result = null;
        for (Medication medication : medications) {

            if (medication.getId() == id) {
                result = medication;
                break;
            }
        }
        return result;
    }

    // Method to search for a Medication by its name
        public Medication searchMedicationByName(String name) {
            Medication result = null;
            for (Medication medication : medications) {
    
                if (medication.getName().equals(name)) {
                    result = medication;
                    break;
                }
            }
            return result;
        }

    // Method to search for a prescription by Patient's id
    public ArrayList<HashMap<String, Object>> searchPrescriptionByPatientId(int patientId) {
        ArrayList<HashMap<String, Object>> prescriptionsForPatient= new ArrayList<HashMap<String, Object>>();
        boolean found = false;
        for (HashMap<String, Object> prescription : prescriptionList) {
            Patient patient = (Patient) prescription.get("patient");
            if (patient.getId() == patientId) {
                found = true;
                prescriptionsForPatient.add(prescription);
            }
        }
        if(found == true)
         return prescriptionsForPatient;
        else
         return null;
    }

    //Method to search a specific prescription for a patient
    public HashMap<String, Object> searchMedicationForPatient(int medId, int patientId) {
        for (HashMap<String, Object> prescription : prescriptionList) {
            Patient patient = (Patient) prescription.get("patient");
            Medication medication = (Medication) prescription.get("medication");
            if (patient.getId() == patientId && medication.getId() == medId) {
                return prescription;
            }
        }
        return null;
    }
    //Method to search a list of prescriptions for a patient
    public ArrayList<HashMap<String, Object>> searchPrescriptionForPatient(int patientId) {
        ArrayList<HashMap<String, Object>> prescriptions = new ArrayList<HashMap<String, Object>>();
    
        for (HashMap<String, Object> prescription : prescriptionList) {
            Patient patient = (Patient) prescription.get("patient");
            if (patient.getId() == patientId) {
                prescriptions.add(prescription);
            }
        }
    
        return prescriptions;
    }

    // Method to add a prescription to the list of prescription information as HashMap objects
    public void addToPrescriptionList(HashMap<String, Object> prescription) {
        prescriptionList.add(prescription);
    }

    // Method to create a Patient object and add it to the list of Patient objects
    public void createPatient(String firstname, String lastname, String email, String password) {
        if(isAccountValid(email, password)){
        int id = patients.size() + 1;
        Patient patient = new Patient(firstname, lastname, id, email, password);
        patients.add(patient);}
        else{
           throw new IllegalArgumentException("Incorrect email address or password.");
        }
    }

    // Method to search for a Patient by their id
    public Patient searchPatient(int id) {
        Patient result = null;
        for (Patient patient : patients) {

            if (patient.getId() == id) {
                result = patient;
                break;
            }
        }
        return result;
    }



    public boolean login(String email, String password) {
           
            for (Patient patient : patients) {
                if (patient.getEmail().equalsIgnoreCase(email)) {
                    if (patient.getPassword().equals(password)) {
                        return true;
                    } else {
                        throw new IllegalArgumentException("The password does not match the email address");
                    }
                }
            }
            throw new IllegalArgumentException("There is no patient with this email");
    }






    public boolean isAccountValid(String email, String password) {
        if (isEmailValid(email) && isPasswordValid(password) ) {
            return true;
        }
        else{
            throw new IllegalArgumentException("Account is not valid");
        }
    }


    public static boolean isEmailValid(String email) {
        int indexOfAT = email.indexOf('@');


        if (indexOfAT == -1){
            return false;
        }
        else {
           
            // check Prefixes
            for(int x =0; x < indexOfAT;x++){
                int cur = email.charAt(x);
               
                // check CHARACTERS


                // 48 - 57 number check
                // 65 - 90 capital letters check
                // 97 - 122 lower case letters check
                // "_" = 95, "." = 46 ,"-" = 45


                // check is the cur char are in the above mentioned range
                if(!((cur>=48 && cur<=57) || (cur>=65 && cur<=90) || (cur>=97 && cur<=122) || cur == 95 || cur == 46 || cur == 45)){
                    return false;
                }  
                else{
                    if(cur == 95 || cur == 46 || cur == 45){
                        // check if "_" "." "-" are at the beginning of email address
                        if(x == 0 ){
                            return false;
                        }
                        //check if the "_" "." "-" are followed by a letter or number
                        int next = email.charAt(x+1);
                        if(!((next>=48 && next<=57) || (next>=65 && next<=90) || (next>=97 && next<=122))){
                            return false;
                        }
                    }
                }


            }


            // check the occurrences of "." Domain
            String domain = email.substring(indexOfAT, email.length());
            if(domain.length()-domain.replace(".", "").length() != 1){
                return false;
            }
           
            // check last portion of Domain
            if(domain.length()-domain.lastIndexOf(".")-1 < 2){
                return false;
            }
           


            // check Domains
            for(int x =indexOfAT+1; x < email.lastIndexOf(".") ;x++){
                int cur = email.charAt(x);
               
                // check CHARACTERS


                // 48 - 57 number check
                // 65 - 90 capital letters check
                // 97 - 122 lower case letters check
                // "_" = 95 ,"-" = 45


                // check is the cur char are in the above mentioned range
                if(!((cur>=48 && cur<=57) || (cur>=65 && cur<=90) || (cur>=97 && cur<=122) || cur == 95 || cur == 45)){
                    return false;
                }  


            }


            return true;
        }
    }


        public boolean isInputValid(String input){
            if(input.length()>0 && !input.equals("") && !input.equals(" ") && input != null){
                return true;
            }else{
                return false;  
                }
        }


        public boolean isPasswordValid(String password) {
            if(password.length()>0 && !password.equals("") && !password.equals(" ") && password != null){
                return true;
            }else{
                return false;  
            }
        }

       

}