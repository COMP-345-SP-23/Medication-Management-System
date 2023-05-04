package edu.ithaca.barr.meds;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

public class UI {
    public static void main(String[] args){
       Hospital hospital = new Hospital();
       Doctor doctor= new Doctor("doctor@email.com", "doctor123", hospital);
       Patient patient = new Patient(null, null, 0, "jackson@email.com", null);
       hospital.patients.add(patient);
       Medication medication;
       String doctorPassword="doctor123";
        
       Scanner scnr = new Scanner(System.in);
       int choice;
        String email;
        String password;
        String firstName;
        String lastName;
        String requestMedicine;
        int id;
        int logoutScan;
        boolean logout = false;
        boolean flag = false;
        boolean login = false;
        
       System.out.println("Welcome to Smart Medication");

       while(true){
        logout = false;
        login = false;
        System.out.println("1. Login");
        System.out.println("2. Signup");
           choice= scnr.nextInt();
           switch(choice){





                //login to account
               case 1:
               System.out.println("Select an option:");
               System.out.println("1.Doctor"+ " 2.Nurse"+ " 3.Patient");
           

               choice= scnr.nextInt();

           

               switch(choice){
                    //Login to Doctor
                
                   case 1:
                   System.out.println("Enter email:");
                   email=scnr.next();

                   
                   
                                     
                   System.out.println("Enter Password:");
                   password= scnr.next();
                
                   
                   if(doctor.getEmail().equals(email) && doctorPassword.equals(password)){
                    System.out.println("Login successful");
                    login = true;
                   }
                   else{
                    System.out.println("Information Invalid");
                   }
                   
                   // Check if the doctor's email and password are correct
                   /*if (!email.equals(email) || !password.equals(doctorPassword)) {
                       System.out.println("Invalid email or password. Please try again.");
                       
                   }
                   */
           
                   
                   while(login == true){
                        System.out.println("//////////////////////////////////////////////////////////////////////");
                        System.out.println("//////////////////////////////////////////////////////////////////////");
                        System.out.println("");
                        System.out.println("Medication");
                        System.out.println("1.Prescribe Medicine");
                        System.out.println("2.Delete Medicine");
                        System.out.println("3.Add Medicine");
                        System.out.println("4.Update Medicine");



                        choice=scnr.nextInt();
                            switch(choice){
                                    
                                    
                                    //Prescribe Medicine
                                    case 1:
                                        System.out.println("Enter patient ID:");
                                        int pId=scnr.nextInt();
                                        System.out.println("Enter medication ID:");
                                        int medId= scnr.nextInt();
                                        System.out.println("Enter frequency:");
                                        int freq= scnr.nextInt();
                                        System.out.println("Enter dosage:");
                                        double dosage=scnr.nextDouble();
                                        System.out.println("Enter totalAmount: ");
                                        int totAmount=scnr.nextInt();

                                        System.out.println("Enter amount per day:");
                                        int perDay = scnr.nextInt();

                                        
                                        try {
                                            doctor.prescribeMedication(pId,medId,dosage,freq,totAmount,perDay);
                                            System.out.println("Medication prescribed successfully.");
                                            
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                            
                                            
                                        }
                                        break;



                                    case 2:
                                        //delete medicine
                                        System.out.println("Enter medication ID:");
                                        int medid=scnr.nextInt();

                                        doctor.deleteMedication(medid);
                                        System.out.println("Medication deleted successfully!");
                                        break;


                                    case 3:
                                        //Add medicine
                                        System.out.println("Enter Medication name: ");
                                        String name= scnr.next();

                                        System.out.println("Enter Medication quantity: ");
                                        int quantity= scnr.nextInt();

                                        doctor.addMedication(name,quantity);
                                        hospital.addToMedications(name, quantity);
                                        System.out.println("Medication  added successfully!");

                                        break;



                                    case 4:
                                        //Update medicine
                                        System.out.println("Enter name of medication: ");
                                        String Medname= scnr.next();

                                        System.out.println("Enter medication ID: ");
                                        id = scnr.nextInt();

                                        System.out.println("Enter Medication quantity: ");
                                        quantity= scnr.nextInt();

                                        doctor.updateMedication(Medname, id, quantity);
                                        System.out.println("Medicine successfully updated!");
                                        break;
                                
                    
                    
                                    }
                                    System.out.println("1. Logout");
                                    System.out.println("2. Keep going");
                                    logoutScan = scnr.nextInt();
                                    if(logoutScan == 1){
                                        logout = true;
                                        login = false;
                                    }


                   
               
               
                        }
                        break;
                    
                    
                    
                    case 3:
                        System.out.println("Enter email:");
                        email=scnr.next();
    
                        if(!hospital.doesPatientExist(email)){
                            System.out.println("Incorrect email");
                        }
                        else{
                            //fix this to match the user
                            patient = hospital.patients.get(0);
                        }
                                        
                        System.out.println("Enter Password:");
                        password= scnr.next();
                    
                        if(!password.equals(patient.getPassword()) ){
                            System.out.println("Incorrect Password. Try again!");
                        }

                        System.out.println("Login succesful!!");

                        while(logout == false){
                            logout = false;
                            System.out.println("//////////////////////////////////////////////////////////////////////");
                            System.out.println("//////////////////////////////////////////////////////////////////////");
                            System.out.println("");
                            System.out.println("1. Request Medication");
                            System.out.println("2. Show Medications");
                            



                            choice=scnr.nextInt();

                                switch(choice){
                                    case 1:
                                        System.out.println("Enter name of medicine you want request: ");
                                        requestMedicine = scnr.next();
                                        System.out.println(hospital.searchPrescriptionByPatientId(hospital.patients.size()-1));
                                        
                                        
                                    break;
                                    case 2:
                                        System.out.println(hospital.searchPrescriptionByPatientId(hospital.patients.size()-1));
                                    break;
                                }
                                System.out.println("1. Logout");
                                System.out.println("2. Keep going");
                                logoutScan = scnr.nextInt();
                                if(logoutScan == 1){
                                    logout = true;
                                }
                        }
                        
                    }
                    break;



           case 2:
           //Create Account
           
     

                            System.out.println("Create a Patient account");
                        
                            System.out.println("Enter your first name: ");
                            firstName = scnr.next();
            
                            try{
                                hospital.isInputValid(firstName);
                            }
                            catch(IllegalArgumentException e){
                                    System.out.println("Input is invalid try again");                
                            }

                            
                            System.out.println("Enter your Last name: ");
                            lastName = scnr.next();
            
                            try{
                                hospital.isInputValid(firstName);
                            }
                            catch(IllegalArgumentException e){
                                    System.out.println("Input is invalid try again");                
                            }
                            
                            
                            System.out.println("Enter your email: ");
                            email = scnr.next();
            
                            try{
                                hospital.isEmailValid(email);
                            }
                            catch(IllegalArgumentException e){
                                    System.out.println("Email is invalid try again");                
                            }
            
                            System.out.println("Create Password:");
                            password =scnr.next();
                            try{
                                hospital.isPasswordValid(password);
                                hospital.createPatient(firstName, lastName, email, password);
                                patient = hospital.searchPatient(hospital.patients.size());
                                System.out.println("Account has been successfully created!!");
                                System.out.println("your patient ID is " + patient.getId());
                            }
                            catch(IllegalArgumentException e){
                                System.out.println("Password is not valid");
                            }
                                      




                
                
                 
           }
       }
   
   }    
}