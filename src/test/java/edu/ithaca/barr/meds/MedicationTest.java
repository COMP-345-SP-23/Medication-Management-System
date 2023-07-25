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
        Medication med = new Medication("Aspirin", 123);
        assertEquals("Aspirin", med.getName());
    }
    /**
     * Tests the getId method of the Medication class.
     */
    @Test
    public void testGetId() {
        Medication med = new Medication("Aspirin", 123);
        assertEquals(123, med.getId());
    }

    /**
     * Tests the getQuantity method of the Medication class.
     */
    @Test
    public void testGetQuantity() {
        Medication med = new Medication("Aspirin", 123);
        med.addMedication(10);
        assertEquals(10, med.getQuantity());
    }

    /**
     * Tests the getHistory method of the medication class.
     */
    @Test
    public void testGetHistory() {
        Medication med = new Medication("Aspirin", 123);
        med.addMedication(10);
        assertEquals(10, med.getHistory().get(0));
    }

    /**
     * Tests the addMedication, reduceMedication, and updateHistory methods of the medication class
     */
    @Test
    public void testAddReduceUpdate() {
        ArrayList<Integer> arr = new ArrayList<>();
        Medication aspirin = new Medication("Aspirin", 123);
        aspirin.addMedication(10);
        arr.add(10);
        assertEquals(aspirin.getQuantity(), 10);

        aspirin.addMedication(10);
        arr.add(10);
        assertEquals(aspirin.getQuantity(), 20);
        assertEquals(aspirin.getHistory(), arr);

        aspirin.reduceMedication(5);
        arr.add(-5);
        assertEquals(aspirin.getQuantity(), 15);
        assertEquals(aspirin.getHistory(), arr);
    }
   
    
}