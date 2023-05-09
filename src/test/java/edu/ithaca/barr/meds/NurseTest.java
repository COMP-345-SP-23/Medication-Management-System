package edu.ithaca.barr.meds;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NurseTest {
 //System test
    @Test
    public void testMedicationTaken() {
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("d@gmail.com","Password123",hospital);

        hospital.createPatient("Simret", "Melak","smelak@ithaca.edu","Password123");
        hospital.createPatient("Nardos", "Mamo","nmamo@ithaca.edu","Password123@");
        hospital.createPatient("John", "Barr","jbarr@ithaca.edu","Password123#");

        //check if it throws an error if invalid email is entered
        assertThrows(IllegalArgumentException.class, () -> {
            hospital.createPatient("John", "Barr","j","Password123#");   
        });
      
        //Checking if the patient accounts are created
        assertEquals("John" , hospital.searchPatient(3).getFirstName());

        hospital.addToMedications("Asprin", 20);
        hospital.addToMedications("Iboprofen", 20);
        hospital.addToMedications("Gofen", 15);

        //Checking if the medications are created and added to the hospital
        assertEquals("Asprin" , hospital.searchMedication(1).getName());
        //Checking if the quantity is right
        assertEquals(20, hospital.searchMedication(2).getQuantity());

        doctor.prescribeMedication(1, 1, 500, 2, 10, 4);
        doctor.prescribeMedication(1, 2, 300, 2, 10, 4);
        doctor.prescribeMedication(3, 1, 500, 2, 10, 4);

        //Check if the Doctor is actually prescribing a medication
        assertEquals(500.00,hospital.prescriptionList.get(0).get("dosage"));

        //Check if the patient can see their prescribed medication
        assertEquals(2,hospital.searchPrescriptionByPatientId(1).size());
        //Check that it returns null if the patient has no prescription
        assertEquals(null,hospital.searchPrescriptionByPatientId(2));

        //Check if searchMedicationForPatient method actually returns the needed prescription
        assertEquals(300.00,hospital.searchMedicationForPatient(2, 1).get("dosage"));
        assertEquals(500.00,hospital.searchPrescriptionByPatientId(1).get(0).get("dosage"));

        Nurse nurse = new Nurse(hospital);

        nurse.medicationTaken(1, 4, 1);
        /*Check if the total amount of medication that a patient is left with 
        is updated whenever they take a medication
        */
        assertEquals(6, hospital.searchMedicationForPatient(1, 1).get("TotalAmount"));
        assertEquals(false, hospital.searchPatient(1).getNotTakenProperly());
         
        /*Check if throws an error when trying to take a med that is not
        prescribed
        */
        assertThrows(IllegalArgumentException.class, () -> {
            nurse.medicationTaken(1, 2, 2);
        });

        
        /* Check that the patients that are not taking their medications properly are
         * flaged and reported to the doctor
         */
        nurse.medicationTaken(1, 2, 1);
        assertEquals(true, hospital.searchPatient(1).getNotTakenProperly());
        assertEquals(1,doctor.getPatientsNotTakingMedProperly().get(0).getId());

        /*Check if the patients are marked as Done with their medication if the 
         total amount left is 0
        */
        nurse.medicationTaken(1, 4, 1);
        assertEquals(1,doctor.getPatientsDone().size());

        /*check if it throws an error when trying to take more than 
         * the total amount prescribed
         */
        assertThrows(IllegalArgumentException.class, () -> {
            nurse.medicationTaken(1, 2, 1);
        });
    }
}
