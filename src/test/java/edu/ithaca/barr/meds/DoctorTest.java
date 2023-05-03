package edu.ithaca.barr.meds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    void testPrescribeMedication() {
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("doctor@example.com", "password", hospital);

        // Add a patient to the hospital
        
        hospital.createPatient("John", "Doe", "john@example.com","Password123");

        // Add a medication to the hospital
        hospital.addToMedications("Med1",90);

        // Test prescribing medication
        doctor.prescribeMedication(hospital.getPatients().get(0).getId(), hospital.getMedications().get(0).getId(), 2.5, 3,10,2);

        // Check if the prescription was added to the prescription list in the hospital
        assertTrue(hospital.getPrescribedMedications().size() > 0);

        // Check if the prescribed medication matches the expected medication
        assertEquals(hospital.getMedications().get(0), hospital.getPrescribedMedications().get(0).get("medication"));

        // Check if the prescribed patient matches the expected patient
        //Patient patient = new Patient("John", "Doe", 1,"john@example.com","Password123")
        assertEquals(hospital.getPatients().get(0), hospital.getPrescribedMedications().get(0).get("patient"));

        // Check if the dosage and frequency match the expected values
        assertEquals(2.5, (double) hospital.getPrescribedMedications().get(0).get("dosage"));
        assertEquals(3, (int) hospital.getPrescribedMedications().get(0).get("frequency"));
    }

    @Test
    void testPrescribeMedicationWithInvalidMedicationId() {
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("doctor@example.com", "password", hospital);

        // Add a patient to the hospital
        hospital.createPatient("John", "Doe", "john@example.com","Password123");

        // Test prescribing medication with invalid medication ID
        assertThrows(IllegalArgumentException.class, () -> {
            doctor.prescribeMedication(hospital.getPatients().get(0).getId(), 100, 2.5, 3,10,2);
        });
    }

    @Test
    void testPrescribeMedicationWithInvalidPatientId() {
        Hospital hospital = new Hospital();
        
        Doctor doctor = new Doctor("doctor@example.com", "password", hospital);

        // Add a medication to the hospital
        hospital.addToMedications("Asprin",10);

        // Test prescribing medication with invalid patient ID
        assertThrows(IllegalArgumentException.class, () -> {
            doctor.prescribeMedication(100, hospital.getMedications().get(0).getId(), 2.5, 3,10,2);
        });
    }

    @Test
    void testGetHistory(){
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("Doc@gmail.com", "123pass#123", hospital);
        doctor.addMedication("Asprin", 20);
        doctor.addMedication("Iboprofen", 40);

        hospital.createPatient("Simret", "Melak","smelak@ithaca.edu","Password123");
        hospital.createPatient("Nardos", "Mamo","nmamo@ithaca.edu","Password123@");
        
        doctor.prescribeMedication(1, 1, 500, 2, 10, 4);
        doctor.prescribeMedication(1, 2, 300, 2, 10, 4);
        doctor.prescribeMedication(2, 1, 500, 2, 10, 4);

        
        //check if the history is updated every time a medication is added or prescribed
        assertEquals(3, doctor.getMedHistory(1).size());

        //check if it updates when medication is added
        assertEquals(20, doctor.getMedHistory(1).get(0));

        //check if it updates when medication is prescribed
        assertEquals(-10, doctor.getMedHistory(1).get(1));

        //check if the current quantity is updated
        assertEquals(0, hospital.searchMedication(1).getQuantity());
        assertEquals(30, hospital.searchMedication(2).getQuantity());
    }

    @Test
    void testGetPatientsNotTakingMedsProperly(){
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("d@gmail.com","Password123",hospital);

        hospital.createPatient("Simret", "Melak","smelak@ithaca.edu","Password123");
        hospital.createPatient("Nardos", "Mamo","nmamo@ithaca.edu","Password123@");
        hospital.createPatient("John", "Barr","jbarr@ithaca.edu","Password123#");

        //Checking if the patient accounts are created
        assertEquals("John" , hospital.searchPatient(3).getFirstName());

        hospital.addToMedications("Asprin", 20);
        hospital.addToMedications("Iboprofen", 20);
        hospital.addToMedications("Gofen", 15);

        //Checking if the medications are created and added to the hospital
        assertEquals("Asprin" , hospital.searchMedication(1).getName());
        //Checking if the quantity is right
        assertEquals(15, hospital.searchMedication(3).getQuantity());

        doctor.prescribeMedication(1, 1, 500, 2, 10, 4);
        doctor.prescribeMedication(1, 2, 300, 2, 10, 4);
        doctor.prescribeMedication(3, 1, 500, 2, 10, 4);

        //Check if the Doctor is actually prescribing a medication
        assertEquals(500.00,hospital.prescriptionList.get(0).get("dosage"));

        Nurse nurse = new Nurse(hospital);

        /* Check that the patients that are not taking their medications properly are
         * flaged and reported to the doctor
         */
        nurse.medicationTaken(1, 2, 1);
        nurse.medicationTaken(1, 3, 3);

        assertEquals(true, hospital.searchPatient(1).getNotTakenProperly());
        assertEquals(1,doctor.getPatientsNotTakingMedProperly().get(0).getId());
        assertEquals(2,doctor.getPatientsNotTakingMedProperly().size());
        
    }

  
}