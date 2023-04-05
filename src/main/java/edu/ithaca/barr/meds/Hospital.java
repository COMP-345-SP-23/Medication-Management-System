package edu.ithaca.barr.meds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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

    HashMap<String,Doctor> doctors = new HashMap<>();
    HashMap<String,Patient> patients = new HashMap<>();

    public boolean createDoctorAccount(String email, String password, String UserType) {
        if(isAccountValid(email, password, password)){
            Doctor newDoctor = new Doctor(email, password);
            // Add new doctor account to the HashMap
            doctors.put(email, newDoctor);
            return true;
        }
        else{
            System.out.println("Account information invalid");
            return false;
        }
    }
    public boolean createPatientAccount(String email, String password, String UserType) {
        if(isAccountValid(email, password, password)){
            Patient newPatient = new Patient(email, password);
            // Add new doctor account to the HashMap
            patients.put(email, newPatient);
            return true;
        }
        else{
            System.out.println("Account information invalid");
            return false;
        }
    }




    public boolean login(String email, String password) {
            // Check if email address is in the HashMap
            if (doctors.containsKey(email)) {
                Doctor doctor = doctors.get(email);
                if (doctor.getPassword().equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                }
                else{
                    System.out.println("Incorrect email address or password.");
                    return false;
                }
            }
            else if(patients.containsKey(email)){
                Patient patient = patients.get(email);
                if (patient.getPassword().equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                }
                else{
                    System.out.println("Incorrect email address or password.");
                    return false;
                }
            }
            else{
                System.out.println("Incorrect email address or password.");
                return false;
            }
    }






    public boolean isAccountValid(String email, String password, String UserType) {
        if (isEmailValid(email) && isPasswordValid(password) && isInputValid(UserType)) {
            return true;
        }
        else{
            return false;
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


        private boolean isPasswordValid(String password) {
            if(password.length()>0 && !password.equals("") && !password.equals(" ") && password != null){
                return true;
            }else{
                return false;  
            }
        }



}