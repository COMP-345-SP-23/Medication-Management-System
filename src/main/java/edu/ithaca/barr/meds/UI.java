package edu.ithaca.barr.meds;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.InputMismatchException;

import java.util.Scanner;




public class UI {

    public static void main(String[] args){

       Hospital hospital = new Hospital();

       Nurse nurse = new Nurse(hospital);

       Doctor doctor= new Doctor("doctor@email.com", "doctor123", hospital);

       String nursePassword = "nurse123";

       

       String doctorPassword="doctor123";

 

       Scanner scnr = new Scanner(System.in);

       

       

        String email;

        String password;

        String firstName;

        String lastName;

        int id;

        int logoutScan;

        boolean logout = false;

        boolean login = false;

       

       System.out.println("Welcome to Smart Medication");

    //    System.out.println("1. Login");

    //    System.out.println("2. Signup");

 

       while(true){

        try{

        int choice;

        logout = false;

        login = false;

        System.out.println("1. Login");

        System.out.println("2. Signup");

           choice= scnr.nextInt();

           switch(choice){

               case 1:

               System.out.println("Select an option:");

               System.out.println("1.Doctor\n"+ "2.Nurse\n"+ "3.Patient\n1");

           

 

               choice= scnr.nextInt();

 

           

           

 

               switch(choice){

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

                   if (!email.equals(email) || !password.equals(doctorPassword)) {

                       System.out.println("Invalid email or password. Please try again.");

                       

                   }

           

                   

                   while(login == true){

                        System.out.println("//////////////////////////////////////////////////////////////////////");

                        System.out.println("//////////////////////////////////////////////////////////////////////");

                        System.out.println("");

                        System.out.println("Medication");

                        System.out.println("1.Prescribe Medicine");

                        System.out.println("2.Delete Medicine");

                        System.out.println("3.Add Medicine");

                        System.out.println("4.Update Medicine");

                        System.out.println("5.Get history of a Medicine");

                        System.out.println("6.Get Patients that are not taking their meds properly");

                        System.out.println("7.Get Patients that are done with their prescription");




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

                                        try{

                                        doctor.deleteMedication(medid);

                                        System.out.println("Medication deleted successfully!");}

                                        catch(IllegalArgumentException e){

                                            System.out.println(e.getMessage());

                                        }

                                        break;

 

                                    case 3:

                                        System.out.println("Enter Medication name: ");

                                        String name= scnr.next();

 

                                        System.out.println("Enter Medication quantity: ");

                                        int quantity= scnr.nextInt();

 

                                                        doctor.addMedication(name,quantity);

                                                        System.out.println("Medication  added successfully!");

                                                        System.out.println("The medication ID is " + (hospital.getMedications().size()));

 

                                        break;

                                    case 4:

                                        System.out.println("Enter name of medication: ");

                                        String Medname= scnr.next();

 

                                        System.out.println("Enter medication ID: ");

                                        id = scnr.nextInt();

 

                                        System.out.println("Enter Medication quantity: ");

                                        quantity= scnr.nextInt();

 

                                        try{

                                        doctor.updateMedication(Medname, id, quantity);

                                        System.out.println("Medicine successfully updated!");}

                                        catch(IllegalArgumentException e){

                                            System.out.println(e.getMessage());

                                        }

                                        break;

                                    case 5 :

                                        System.out.println("Enter medication ID : ");

                                        id = scnr.nextInt();

                                        System.out.println("The amount of " + hospital.searchMedication(id).getName() + "left in stock is " + hospital.searchMedication(id).getQuantity());

                                        ArrayList<Integer> history = doctor.getMedHistory(id);

                                        for(int i = 0; i< history.size();i++){

                                            if(history.get(i)<0){

                                                System.out.println(history.get(i) + " Sold");

                                            }

                                            else

                                                System.out.println(history.get(i) + " Purchased");

                                        }

                                        break;

                                    case 6:

                                        ArrayList<Patient> patients = doctor.getPatientsNotTakingMedProperly();

                                        if(patients.size()==0){

                                            System.out.println("There are no patients that are not taking their medications properly");

                                        }

                                        for(Patient patient : patients){

                                            System.out.println("ID :" + patient.getId());

                                            System.out.println("First Name : " + patient.getFirstName());

                                            System.out.println("Last Name : " + patient.getLastName());

                                            System.out.println("Email : " + patient.getEmail());

                                            System.out.println("==========================================");

                                        }

                                        break;

 

                                    case 7 :

                                    ArrayList<Patient> patientsDone = doctor.getPatientsDone();

                                    if(patientsDone.size()==0){

                                        System.out.println("There are no patients that are done with their prescribed medications");

                                    }

                                    for(Patient patient : patientsDone){

                                        System.out.println("ID :" + patient.getId());

                                        System.out.println("First Name : " + patient.getFirstName());

                                        System.out.println("Last Name : " + patient.getLastName());

                                        System.out.println("Email : " + patient.getEmail());

                                        System.out.println("==========================================");

                                    }

                                    break;

                                    default:

                                        System.out.println("Enter numbers 1 to 7");

                                   

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

                    case 2 :

                    System.out.println("Enter Password : " );

                    String pass = scnr.next();

                    if(!pass.equals(nursePassword)){

                        System.out.println("Invalid Passowrd");

                        logout = true;

                    }

                                   

                    while(logout == false){

 

                        logout = false;

                        System.out.println("1. Give Medication");

                        System.out.println("2. Get the list of Patients done with their medication");

                        System.out.println("3. Get the list of patients not taking their Meds properly");

                        System.out.println("4. Check prescriptions for a patient");

 

                        choice=scnr.nextInt();

 

                        switch(choice){

                            //Nurse case 1

                            case 1:

                            System.out.println("Enter Patient ID: ");

                            int pid = scnr.nextInt();

                            System.out.println("Enter the Medication ID: ");

                            int mid = scnr.nextInt();

                            System.out.println("Enter the amount you are taking : ");

                            int quantity = scnr.nextInt();

                            try{

                                nurse.medicationTaken(mid, quantity, pid);

                            }

                            catch(IllegalArgumentException e){

                                System.out.println(e.getMessage());

                            }

                            break;

                            //Nurse case 2

                           case 2 :

                           ArrayList<Patient> patientsDone = doctor.getPatientsDone();

                           if(patientsDone.size()==0){

                               System.out.println("There are no patients that are done with their prescribed medications");

                           }

                           for(Patient patient : patientsDone){

                               System.out.println("ID :" + patient.getId());

                               System.out.println("First Name : " + patient.getFirstName());

                               System.out.println("Last Name : " + patient.getLastName());

                               System.out.println("Email : " + patient.getEmail());

                               System.out.println("==========================================");

                           }

                           break;

 

                           //Nurse case 3

                           case 3:

                           ArrayList<Patient> patients = doctor.getPatientsNotTakingMedProperly();

                           if(patients.size()==0){

                               System.out.println("There are no patients that are not taking their medications properly");

                           }

                           for(Patient patient : patients){

                               System.out.println("ID :" + patient.getId());

                               System.out.println("First Name : " + patient.getFirstName());

                               System.out.println("Last Name : " + patient.getLastName());

                               System.out.println("Email : " + patient.getEmail());

                               System.out.println("==========================================");

                           }

                           break;

                           case 4:

                           System.out.println("Enter patient ID : ");

                                        pid = scnr.nextInt();

                                        ArrayList<HashMap<String, Object>> prescription = hospital.searchPrescriptionByPatientId(pid);

                                        if(prescription.size()==0){

                                            System.out.println("ThIS patient don't have any prescribed medication");

                                        }

                                        for(HashMap<String, Object> p : prescription){

                                            Medication med =(Medication) p.get("medication");

                                            System.out.println("Medicine : " + med.getName());

                                            System.out.println("Dosage : " + p.get("dosage"));

                                            System.out.println(p.get("frequency") + " times per day");

                                            System.out.println(p.get("TotalAmount") + " in total");

                                            System.out.println(p.get("amountPerDay") + " per day");

                                            System.out.println("=======================================");

                                        }

                   

                                    break;

 

                           default :

                                System.out.println("Enter the numbers 1 - 3");

 

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

                   

                    //Cases for the Patient

                    case 3:

                        System.out.println("Enter your ID : ");

                        id = scnr.nextInt();

                        if(hospital.searchPatient(id)== null){

                            System.out.println("No patient with this ID");

                            break;

                        }

                        Patient patient = hospital.searchPatient(id);

                        System.out.println("Enter email:");

                        email=scnr.next();

 

                   

                   

                                     

                        System.out.println("Enter Password:");

                        password= scnr.next();

 

                    // Check if the doctor's email and password are correct

                   if (!patient.getEmail().equals(email) || !patient.getPassword().equals(doctorPassword)) {

                       //System.out.println("Invalid email or password. Please try again.");

                       login = false;

                       

               

                   

                   if(patient.getEmail().equals(email) && patient.getPassword().equals(password)){

                    System.out.println("Login successful");

                    login = true;

                   }

                   else{

                    System.out.println("Information Invalid");

                    login = false;

                    break;

                   }

                       

                   }

 

                        while(logout == false){

                            logout = false;

                            System.out.println("//////////////////////////////////////////////////////////////////////");

                            System.out.println("//////////////////////////////////////////////////////////////////////");

                            System.out.println("");

                            System.out.println("1. Input Medication taken");

                            System.out.println("2. Show Medications");

                           




                            choice=scnr.nextInt();

 

                                switch(choice){

                                    case 1:

                                        System.out.println("Enter your ID: ");

                                        int pid = scnr.nextInt();

                                        System.out.println("Enter the Medication ID: ");

                                        int mid = scnr.nextInt();

                                        System.out.println("Enter the amount you are taking : ");

                                        int quantity = scnr.nextInt();

                                        try{

                                            nurse.medicationTaken(mid, quantity, pid);

                                        }

                                        catch(IllegalArgumentException e){

                                            System.out.println(e.getMessage());

                                        }

                       

                                       

                                         

                                    break;

                                    case 2:

                                        System.out.println("Enter your ID : ");

                                        pid = scnr.nextInt();

                                        ArrayList<HashMap<String, Object>> prescription = hospital.searchPrescriptionByPatientId(pid);

                                        if(prescription.size()==0){

                                            System.out.println("You don't have any prescribed medication");

                                        }

                                        for(HashMap<String, Object> p : prescription){

                                            Medication med =(Medication) p.get("medication");

                                            System.out.println("Medicine : " + med.getName());

                                            System.out.println("Dosage : " + p.get("dosage"));

                                            System.out.println(p.get("frequency") + " times per day");

                                            System.out.println("Take " + p.get("TotalAmount") + " in total");

                                            System.out.println("Take " + p.get("amountPerDay") + " per day");

                                            System.out.println("=======================================");

                                        }

                   

                                    break;

                                   

                                    default:

                                        System.out.println("Enter numbers 1 or 2");

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

                                Patient patient = hospital.searchPatient(hospital.patients.size());

                                System.out.println("Account has been successfully created!!");

                                System.out.println("your patient ID is " + patient.getId());

                            }

                            catch(IllegalArgumentException e){

                                System.out.println("Password is not valid");

                            }

                             

                        break;

 

            default:

                         System.out.println("Invalid option");

 

                            break;        

               

                 

           }

        }

        catch(InputMismatchException e){

            System.out.println("Invalid Input");

            break;

        }

       

       }

   

       

   }    

}