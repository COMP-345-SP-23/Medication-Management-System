
package edu.ithaca.barr.meds;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    @Test
    public void testAddToMedications() {
        Hospital hospital = new Hospital();

        hospital.addToMedications("Medication1",9);
        hospital.addToMedications("Medication2",8);

        assertEquals(2, hospital.getMedications().size());
    }

    @Test
    public void testSearchMedication() {
        Hospital hospital = new Hospital();

        hospital.addToMedications("Medication1",78);
        hospital.addToMedications("Medication2",65);

        Medication medication1 = hospital.searchMedication(1);
        Medication medication2 = hospital.searchMedication(2);

        assertNotNull(medication1);
        assertNotNull(medication2);
        assertEquals("Medication1", medication1.getName());
        assertEquals("Medication2", medication2.getName());
    }

    @Test
    public void testAddToPrescriptionList() {
        Hospital hospital = new Hospital();

        hospital.addToMedications("Medication1",56);
        hospital.addToMedications("Medication2",70);

        HashMap<String, Object> prescription1 = new HashMap<>();
        prescription1.put("medication", hospital.getMedications().get(0));
        prescription1.put("patient", new Patient("John", "Doe", 1, "john.doe@example.com", "password"));
        prescription1.put("dosage",200);
        prescription1.put("frequency",1);

        HashMap<String, Object> prescription2 = new HashMap<>();
        prescription2.put("medication", hospital.getMedications().get(1));
        prescription2.put("patient", new Patient("Jane", "Doe", 2, "jane.doe@example.com", "password"));
        prescription2.put("dosage",500);
        prescription2.put("frequency",2);

        hospital.addToPrescriptionList(prescription1);
        hospital.addToPrescriptionList(prescription2);

        assertEquals(2, hospital.getPrescribedMedications().size());
    }

    @Test
    public void testSearchPrescriptionByPatientId() {
        Hospital hospital = new Hospital();

        hospital.addToMedications("Medication1",90);
        hospital.addToMedications("Medication2",80);

        HashMap<String, Object> prescription1 = new HashMap<>();
        prescription1.put("medication", hospital.getMedications().get(0));
        prescription1.put("patient", new Patient("John", "Doe", 1, "john.doe@example.com", "password"));
        prescription1.put("dosage",200);
        prescription1.put("frequency",1);

        HashMap<String, Object> prescription2 = new HashMap<>();
        prescription2.put("medication", hospital.getMedications().get(1));
        prescription2.put("patient", new Patient("Jane", "Doe", 2, "jane.doe@example.com", "password"));
        prescription2.put("dosage",500);
        prescription2.put("frequency",2);

        hospital.addToPrescriptionList(prescription1);
        hospital.addToPrescriptionList(prescription2);

        HashMap<String, Object> result = hospital.searchPrescriptionByPatientId(1);

        assertNotNull(result);
        assertEquals("John", ((Patient) result.get("patient")).getFirstName());
    }

    @Test
    public void testCreatePatient() {
        Hospital hospital = new Hospital();

        hospital.createPatient("John", "Doe", "john.doe@example.com", "password");
        hospital.createPatient("Jane", "Doe", "jane.doe@example.com", "password");

        assertEquals(2, hospital.getPatients().size());
    }
    @Test
public void testSearchMedicationForPatient() {
    Hospital hospital = new Hospital();

    // Add two medications to the hospital's list of medications
    hospital.addToMedications("Medication1", 78);
    hospital.addToMedications("Medication2", 65);

    // Add two prescriptions to the hospital's list of prescriptions
    HashMap<String, Object> prescription1 = new HashMap<>();
    prescription1.put("medication", hospital.getMedications().get(0));
    prescription1.put("patient", new Patient("John", "Doe", 1, "john.doe@example.com", "password"));
    prescription1.put("dosage", 200);
    prescription1.put("frequency", 1);
    hospital.addToPrescriptionList(prescription1);

    HashMap<String, Object> prescription2 = new HashMap<>();
    prescription2.put("medication", hospital.getMedications().get(1));
    prescription2.put("patient", new Patient("Jane", "Doe", 2, "jane.doe@example.com", "password"));
    prescription2.put("dosage", 500);
    prescription2.put("frequency", 2);
    hospital.addToPrescriptionList(prescription2);

    // Search for prescription for patient 1 and medication 1 and verify the results
    HashMap<String, Object> foundPrescription1 = hospital.searchMedicationForPatient(1, 1);
    assertNotNull(foundPrescription1);
    assertEquals("Medication1", ((Medication) foundPrescription1.get("medication")).getName());
    assertEquals(200, foundPrescription1.get("dosage"));
    assertEquals(1, foundPrescription1.get("frequency"));

    // Search for prescription for patient 2 and medication 2 and verify the results
    HashMap<String, Object> foundPrescription2 = hospital.searchMedicationForPatient(2, 2);
    assertNotNull(foundPrescription2);
    assertEquals("Medication2", ((Medication) foundPrescription2.get("medication")).getName());
    assertEquals(500, foundPrescription2.get("dosage"));
    assertEquals(2, foundPrescription2.get("frequency"));

    // Search for prescription for non-existing patient and medication combination and verify the results
    HashMap<String, Object> foundPrescription3 = hospital.searchMedicationForPatient(3, 1);
    assertNull(foundPrescription3);
}
 @Test
public void testSearchPrescriptionForPatient()  {
        Hospital hospital = new Hospital();
    

        // Add two medications to the hospital's list of medications
        hospital.addToMedications("Medication1", 78);
        hospital.addToMedications("Medication2", 65);

        // Add a new medication to the hospital's list of medications
        hospital.addToMedications("Aspirin",10);

        // Add three prescriptions to the hospital's list of prescriptions
        HashMap<String, Object> prescription1 = new HashMap<>();
        prescription1.put("medication", hospital.getMedications().get(0));
        prescription1.put("patient", new Patient("John", "Doe", 1, "john.doe@example.com", "password"));
        prescription1.put("dosage", 200);
        prescription1.put("frequency", 1);
        hospital.addToPrescriptionList(prescription1);
    
        HashMap<String, Object> prescription2 = new HashMap<>();
        prescription2.put("medication", hospital.getMedications().get(1));
        prescription2.put("patient", new Patient("John", "Doe", 1, "john.doe@example.com", "password"));
        prescription2.put("dosage", 500);
        prescription2.put("frequency", 2);
        hospital.addToPrescriptionList(prescription2);
    

        HashMap<String, Object> prescription3 = new HashMap<>();
        prescription3.put("medication", hospital.getMedications().get(0));
        prescription3.put("patient", new Patient("Jane", "Doe", 2, "jane.doe@example.com", "password"));
        prescription3.put("dosage", 300);
        prescription3.put("frequency", 3);
        hospital.addToPrescriptionList(prescription3);

        // Search for the medication for the patient
        HashMap<String,Object> prescription = hospital.searchMedicationForPatient(1, 1);
        Medication medication = (Medication)prescription.get("medication");

    
        // Search for prescriptions for patient 1 and verify the results
        ArrayList<HashMap<String, Object>> foundPrescriptions1 = hospital.searchPrescriptionForPatient(1);
        assertNotNull(foundPrescriptions1);
        assertEquals(2, foundPrescriptions1.size());
        assertEquals("Medication1", ((Medication) foundPrescriptions1.get(0).get("medication")).getName());
        assertEquals(200, foundPrescriptions1.get(0).get("dosage"));
        assertEquals(1, foundPrescriptions1.get(0).get("frequency"));
        assertEquals("Medication2", ((Medication) foundPrescriptions1.get(1).get("medication")).getName());
        assertEquals(500, foundPrescriptions1.get(1).get("dosage"));
        assertEquals(2, foundPrescriptions1.get(1).get("frequency"));
    
        // Search for prescriptions for patient 2 and verify the results
        ArrayList<HashMap<String, Object>> foundPrescriptions2 = hospital.searchPrescriptionForPatient(2);
        assertNotNull(foundPrescriptions2);
        assertEquals(1, foundPrescriptions2.size());
        assertEquals("Medication1", ((Medication) foundPrescriptions2.get(0).get("medication")).getName());
        assertEquals(300, foundPrescriptions2.get(0).get("dosage"));
        assertEquals(3, foundPrescriptions2.get(0).get("frequency"));
    
        // Search for prescriptions for non-existing patient and verify the results
        ArrayList<HashMap<String, Object>> foundPrescriptions3 = hospital.searchPrescriptionForPatient(3);
        assertNotNull(foundPrescriptions3);
        assertEquals(0, foundPrescriptions3.size());
    }   

// @Test
    // void isEmailValidTest(){
    //     Hospital DoctorAccount = new Hospital();
    //     assertTrue(DoctorAccount.isEmailValid( "a@b.com"));   // valid email address
    //     assertTrue(DoctorAccount.isEmailValid( "a-b@b.com")); // valid placement of dash
    //     assertTrue(DoctorAccount.isEmailValid( "a_b@b.com")); // valid placement of underscore
    //     assertFalse(DoctorAccount.isEmailValid(""));         // empty string
    //     assertTrue(DoctorAccount.isEmailValid( "a.b@b.com")); // Valid Placement of dot


    //     assertFalse(DoctorAccount.isEmailValid( "a-@b.com")); //Tests there is no special character before the @
    //     assertFalse(DoctorAccount.isEmailValid( "a..b@b.com")); //Tests that there are no special characters next to each other
    //     assertFalse(DoctorAccount.isEmailValid( ".a@b.com"));  //Tests that email doesn't start with a special character
    //     assertFalse(DoctorAccount.isEmailValid( "a#b@b.com")); //Tests there there are no invalid characters
    // }
    // @Test
    // public void createAccountTest(){
    //     Hospital app = new Hospital();
        
    //     //Testing create doctor works with good inputs
    //     assertTrue(app.createDoctorAccount("a@b.com", "password123", "Doctor"));

    //     //Testing create patient works with good inputs
    //     assertTrue(app.createPatientAccount("a@b.com", "password123", "Patient", "John", "Doe", 1));
        
    //     // Make sure create doctor fails with invalid email
    //     assertFalse(app.createDoctorAccount("a..b@b.com", "password123", "Doctor"));

    //     // Make sure create patient fails with invalid email
    //     assertFalse(app.createPatientAccount("a..b@b.com", "password123", "Patient", "Jane", "Doe", 2));

    //     // Make sure create doctor fails with invalid password
    //     assertFalse(app.createDoctorAccount("a@b.com", " ", "Doctor"));

    //     // Make sure create patient fails with invalid password
    //     assertFalse(app.createPatientAccount("a@b.com", " ", "Patient", "Mike", "Smith", 3));
    // }
    // @Test
    // public void testLogin() {
    //     Hospital app = new Hospital();

    //     app.createDoctorAccount("a@b.com", "password123", "Doctor");
    //     // Test login works for doctor account that exists login
    //     assertTrue(app.login("a@b.com", "password123"));

    //     app.createPatientAccount("a@c.com", "password123", "Patient", "John", "Doe", 1);
    //     // Test login works for doctor account that exists login
    //     assertTrue(app.login("a@c.com", "password123"));

    //     // Test login doesn't work with account that doesnt exist
    //     assertFalse(app.login("a@d.com", "password123")); 


        
    // }

}
