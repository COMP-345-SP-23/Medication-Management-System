package edu.ithaca.barr.meds;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

public class UI {
    public static void main(String[] args){
       Hospital hospital = new Hospital();
       Doctor doctor= new Doctor("doctor@email.com", "doctor123", hospital);
       
       String doctorPassword="doctor123";

       Scanner scnr = new Scanner(System.in);
       int choice;

       System.out.println("Welcome to Smart Medication");
       System.out.println("1. Login");
       System.out.println("2. Signup");

       while(true){
           choice= scnr.nextInt();
           switch(choice){
               case 1:
               System.out.println("Select an option:");
               System.out.println("1.Doctor"+ " 2.Nurse"+ " 3.Patient");
           

               choice= scnr.nextInt();

           

               switch(choice){
                   case 1:
                   System.out.println("Enter email:");
                   String email=scnr.next();
                   
                   System.out.println("Enter Password:");
                   String password= scnr.next();

                   // if(!password.equals(doctorPassword) ){
                   //     System.out.println("Incorrect Password. Try again!");
                   // }
                   
                   // Check if the doctor's email and password are correct
                   if (!email.equals(email) || !password.equals(doctorPassword)) {
                       System.out.println("Invalid email or password. Please try again.");
                       
                   }
           
                   else{

                       System.out.println("Medication");
                       System.out.println("1.Prescribe Medicine");
                       System.out.println("2.Delete Medicine");
                       System.out.println("3.Add Medicine");
                       System.out.println("4.Update Medicine");
                   }
               
                   choice=scnr.nextInt();

                       switch(choice){
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

                           // doctor.prescribeMedication(pId, medId, dosage, freq);
                           try {
                               doctor.prescribeMedication(pId,medId,dosage,freq,totAmount,perDay);
                               System.out.println("Medication prescribed successfully.");
                           } catch (IllegalArgumentException e) {
                               System.out.println(e.getMessage());
                               
                               
                           }
                           break;
                       case 2: 
                           System.out.println("Enter medication ID:");
                           int medid=scnr.nextInt();

                           doctor.deleteMedication(medid);
                           System.out.println("Medication deleted successfully!");
                           break;

                       case 3:
                           System.out.println("Enter Medication name: ");
                           String name= scnr.next();

                           System.out.println("Enter Medication quantity: ");
                           int quantity= scnr.nextInt();

                           doctor.addMedication(name,quantity);
                           System.out.println("Medication  added successfully!");

                           break;
                       case 4:
                           System.out.println("Enter name of medication: ");
                           String Medname= scnr.next();

                           System.out.println("Enter medication ID: ");
                           int id = scnr.nextInt();

                           System.out.println("Enter Medication quantity: ");
                           quantity= scnr.nextInt();

                           doctor.updateMedication(Medname, id, quantity);
                           System.out.println("Medicine successfully updated!");
                           break;
                   }
                   break;
               }
               break;
           case 2: 
               System.out.println("Create an accout");
               
               System.out.println("Enter your email: ");
               String email = scnr.next();

               try{
                   hospital.isEmailValid(email);
               }
               catch(IllegalArgumentException e){
                       System.out.println("Email is invalid try again");                
               }

               System.out.println("Create Password:");
               String password =scnr.next();
               try{
                   hospital.isPasswordValid(password);
                   
                   System.out.println("Account has been successfully created!!");
               }
               catch(IllegalArgumentException e){
                   System.out.println("Password is not valid");
               }
               break;    
           }
       }
   
   }    
}