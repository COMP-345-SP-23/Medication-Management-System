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
        hospital.addToMedications("Med1");

        // Test prescribing medication
        doctor.prescribeMedication(hospital.getPatients().get(0).getId(), hospital.getMedications().get(0).getId(), 2.5, 3);

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
            doctor.prescribeMedication(hospital.getPatients().get(0).getId(), 100, 2.5, 3);
        });
    }

    @Test
    void testPrescribeMedicationWithInvalidPatientId() {
        Hospital hospital = new Hospital();
        
        Doctor doctor = new Doctor("doctor@example.com", "password", hospital);

        // Add a medication to the hospital
        hospital.addToMedications("Asprin");

        // Test prescribing medication with invalid patient ID
        assertThrows(IllegalArgumentException.class, () -> {
            doctor.prescribeMedication(100, hospital.getMedications().get(0).getId(), 2.5, 3);
        });
    }

}