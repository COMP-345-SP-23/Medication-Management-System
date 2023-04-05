package edu.ithaca.barr.meds;

import org.junit.jupiter.api.Test;

public class PatientTest {
    
    @Test
    public void viewMedicationTest() {
        //creating a list of available medications
        Hospital hospital = new Hospital();
        Medication advil = new Medication("advil", 1, 500.00, 2);
        Medication tylenol = new Medication("tylenol", 2, 500.00, 2);
        hospital.medications.add(advil);
        hospital.medications.add(tylenol);

        Patient p1 = new Patient("patient", "smith", 1, "patient@a.com", "password");
        p1.requestMedication("advil");
        assertTrue(p1.viewMedication().contains(advil));
    }

    @Test
    public void requestMedicationTest() {

    }

    @Test
    public void isPrescribedTest() {
        
    }

}
