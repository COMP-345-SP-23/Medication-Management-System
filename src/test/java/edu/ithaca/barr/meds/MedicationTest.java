package edu.ithaca.barr.meds;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class MedicationTest {
    /**
     * Tests the getName method of the Medication class.
     */
    @Test
    public void testGetName() {
        Medication med = new Medication("Aspirin", 123, 10);
        assertEquals("Aspirin", med.getName());
    }
    /**
     * Tests the getId method of the Medication class.
     */
    @Test
    public void testGetId() {
        Medication med = new Medication("Aspirin", 123, 10);
        assertEquals(123, med.getId());
    }

    /**
     * Tests the getQuantity method of the Medication class.
     */
    @Test
    public void testGetQuantity() {
        Medication med = new Medication("Aspirin", 123, 10);
        assertEquals(10, med.getQuantity());
    }

    /**
     * Tests the getHistory method of the medication class.
     */
    @Test
    public void testGetHistory() {
        Medication med = new Medication("Aspirin", 123, 10);
        assertEquals(new ArrayList<Integer>(), med.getHistory());
    }

    /**
     * Tests the addMedication, reduceMedication, and updateHistory methods of the medication class
     */
    @Test
    public void testAddReduceUpdate() {
        new Hospital();
        Medication med = new Medication("Aspirin", 123, 10);
        ArrayList<Integer> arr1 = new ArrayList<>();

        assertEquals(Hospital.medications.size(), 0);
        med.addMedication();
        assertEquals(Hospital.medications.size(), 1);
        arr1.add(10);
        assertEquals(med.getHistory(), arr1);

        med.reduceMedication();
        assertEquals(Hospital.medications.size(), 0);
        arr1.add(-10);
        assertEquals(med.getHistory(), arr1);
    }
   
    
}