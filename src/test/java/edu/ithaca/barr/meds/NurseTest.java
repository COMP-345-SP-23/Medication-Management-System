package edu.ithaca.barr.meds;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NurseTest {

    @Test
    public void testMedicationTaken() {
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("d@gmail.com","Password123",hospital);

        hospital.createPatient("Simret", "Melak","smelak@ithaca.edu","Password123");
        hospital.createPatient("Nardos", "Mamo","nmamo@ithaca.edu","Password123@");
        hospital.createPatient("John", "Barr","jbarr@ithaca.edu","Password123#");

        //Checking if the patient accounts are created
        assertEquals("John" , hospital.searchPatient(3).getFirstName());

        hospital.addToMedications("Asprin", 10);
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

        //check if searchMedicationForPatient method actually returns the needed prescription
        assertEquals(300.00,hospital.searchMedicationForPatient(2, 1).get("dosage"));
        assertEquals(500.00,hospital.searchPrescriptionByPatientId(1).get(0).get("dosage"));




    }
}
