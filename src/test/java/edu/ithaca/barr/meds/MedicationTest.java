package edu.ithaca.barr.meds;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
   
    
}