package edu.ithaca.barr.meds;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    @Test
    public void testAddToMedications() {
        Hospital hospital = new Hospital();

        hospital.addToMedications("Medication1");
        hospital.addToMedications("Medication2");

        assertEquals(2, hospital.getMedications().size());
    }

    @Test
    public void testSearchMedication() {
        Hospital hospital = new Hospital();

        hospital.addToMedications("Medication1");
        hospital.addToMedications("Medication2");

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

        hospital.addToMedications("Medication1");
        hospital.addToMedications("Medication2");

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

        hospital.addToMedications("Medication1");
        hospital.addToMedications("Medication2");

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
