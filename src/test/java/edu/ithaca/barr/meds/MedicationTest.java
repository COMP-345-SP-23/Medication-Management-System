package edu.ithaca.barr.meds;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MedicationTest {
    /**
     * Tests the getName method of the Medication class.
     */
    @Test
    public void testGetName() {
        Medication med = new Medication("Aspirin", 123, 10, new ArrayList<Integer>());
        assertEquals("Aspirin", med.getName());
    }
    /**
     * Tests the getId method of the Medication class.
     */
    @Test
    public void testGetId() {
        Medication med = new Medication("Aspirin", 123, 10, new ArrayList<Integer>());
        assertEquals(123, med.getId());
    }

    /**
     * Tests the getQuantity method of the Medication class.
     */
    @Test
    public void testGetQuantity() {
        Medication med = new Medication("Aspirin", 123, 10, new ArrayList<Integer>());
        assertEquals(10, med.getQuantity());
    }

    /**
     * Tests the getHistory method of the medication class.
     */
    @Test
    public void testGetHistory() {
        Medication med = new Medication("Aspirin", 123, 10, new ArrayList<Integer>());
        assertEquals(new ArrayList<Integer>(), med.getHistory());
    }

    /**
     * Tests the addMedication, reduceMedication, and updateHistory methods of the medication class
     */
    @Test
    public void testAddReduceUpdate() {
        Hospital hospital = new Hospital();
        Medication med = new Medication("Aspirin", 123, 10, new ArrayList<Integer>());

        assertEquals(hospital.medications.size(), 0);
        med.addMedication();
        assertEquals(hospital.medications.size(), 1);
        assertEquals(med.getHistory(), 10);

        med.reduceMedication();
        assertEquals(hospital.medications.size(), 0);
        assertArrayEquals(toArray(med.getHistory()), new int[]{10, -10});
    }
   
    
}