package edu.ithaca.barr.meds;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class HospitalTest {

    @Test
    void testGetMedications() {
        // Create a new Hospital instance
        Hospital hospital = new Hospital();
        
        // Get the list of medications from the hospital
        ArrayList<Medication> medications = hospital.getMedications();
        
        // Ensure the medications list is not null and initially has size 0
        assertNotNull(medications);
        assertEquals(0, medications.size());
    }

    @Test
    void testSearchMedicationFound() {
        // Create a new Hospital instance
        Hospital hospital = new Hospital();
        
        // Create two medications to add to the hospital's medications list
        Medication medication1 = new Medication("ibroprofin", 1, 3, 2);
        Medication medication2 = new Medication("Acetaminophen",2, 1, 2);
        
        // Add the medications to the hospital's medications list
        hospital.medications.add(medication1);
        hospital.medications.add(medication2);
        
        // Search for the medication with ID 2 and ensure it is found and equal to the expected medication
        Medication result = hospital.searchMedication(2);
        assertNotNull(result);
        assertEquals(medication2, result);
    }

    @Test
    void testSearchMedicationNotFound() {
        // Create a new Hospital instance
        Hospital hospital = new Hospital();
        
        // Create a medication to add to the hospital's medications list
        Medication medication = new Medication("Ibuprofen",1,2, 1);
        
        // Add the medication to the hospital's medications list
        hospital.medications.add(medication);
        
        // Search for a medication with ID 2 that does not exist and ensure the result is null
        Medication result = hospital.searchMedication(2);
        assertNull(result);
    }
}