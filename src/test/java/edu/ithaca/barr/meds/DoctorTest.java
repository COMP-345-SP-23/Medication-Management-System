package edu.ithaca.barr.meds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoctorTest {

    @Test
    public void testAddMedication() {
        Doctor doctor = new Doctor(null, null);
        doctor.addMedication("Ibuprofen", 12345, 200.0, 2);
        assertEquals(1, doctor.hospital.getMedications().size());
    }

    @Test
    public void testDeleteMedication() {
        Doctor doctor = new Doctor(null, null);
        doctor.addMedication("Ibuprofen", 12345, 200.0, 2);
        doctor.deleteMedication(12345);
        assertEquals(0, doctor.hospital.getMedications().size());
    }

 

    @Test
    public void testUpdateMedication() {
        Doctor doctor = new Doctor(null, null);
        doctor.addMedication("Ibuprofen", 12345, 200.0, 2);
        doctor.updateMedication("Aspirin", 12345, 300.0, 3);
        Medication medication = doctor.hospital.searchMedication(12345);
        assertEquals("Aspirin", medication.getName());
        assertEquals(300.0, medication.getDosage(), 0.001);
        assertEquals(3, medication.getFrequency());
    }
}