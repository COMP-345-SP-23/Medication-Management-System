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
    @Test
    void isEmailValidTest(){
        Hospital DoctorAccount = new Hospital();
        assertTrue(DoctorAccount.isEmailValid( "a@b.com"));   // valid email address
        assertTrue(DoctorAccount.isEmailValid( "a-b@b.com")); // valid placement of dash
        assertTrue(DoctorAccount.isEmailValid( "a_b@b.com")); // valid placement of underscore
        assertFalse( DoctorAccount.isEmailValid(""));         // empty string
        assertTrue(DoctorAccount.isEmailValid( "a.b@b.com")); // Valid Placement of dot


        assertFalse(DoctorAccount.isEmailValid( "a-@b.com")); //Tests there is no special character before the @
        assertFalse(DoctorAccount.isEmailValid( "a..b@b.com")); //Tests that there are no special characters next to each other
        assertFalse(DoctorAccount.isEmailValid( ".a@b.com"));  //Tests that email doesn't start with a special character
        assertFalse(DoctorAccount.isEmailValid( "a#b@b.com")); //Tests there there are no invalid characters
    }
    @Test
    public void createAccountTest(){
        Hospital app = new Hospital();
        
        //Testing create doctor works with good inputs
        assertTrue(app.createDoctorAccount("a@b.com", "password123", "Doctor"));

        //Testing create patient works with good inputs
        assertTrue(app.createPatientAccount("a@b.com", "password123", "Patient"));
        
        // Make sure create doctor fails with invalid email
        assertFalse(app.createDoctorAccount("a..b@b.com", "password123", "Doctor"));

        // Make sure create patient fails with invalid email
        assertFalse(app.createPatientAccount("a..b@b.com", "password123", "Patient"));

        // Make sure create doctor fails with invalid password
        assertFalse(app.createDoctorAccount("a@b.com", " ", "Doctor"));

        // Make sure create patient fails with invalid password
        assertFalse(app.createPatientAccount("a@b.com", " ", "Patient"));
    }
    @Test
    public void testLogin() {
        Hospital app = new Hospital();

        app.createDoctorAccount("a@b.com", "password123", "Doctor");
        // Test login works for doctor account that exists login
        assertTrue(app.login("a@b.com", "password123"));

        app.createPatientAccount("a@c.com", "password123", "Patient");
        // Test login works for doctor account that exists login
        assertTrue(app.login("a@c.com", "password123"));

        // Test login doesn't work with account that doesnt exist
        assertFalse(app.login("a@d.com", "password123"));


        
    }

}