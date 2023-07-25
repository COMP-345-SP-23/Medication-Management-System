package edu.ithaca.barr.meds;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    
    
        @Test
        public void testGetters() {
            // Create a patient object
            Patient patient = new Patient("John", "Doe", 1234, "john.doe@example.com", "password");
    
            // Test the getters
            assertEquals("John", patient.getFirstName());
            assertEquals("Doe", patient.getLastName());
            assertEquals(1234, patient.getId());
            assertEquals("john.doe@example.com", patient.getEmail());
            assertEquals("password", patient.getPassword());
        }
    
        @Test
        public void testSetters() {
            // Create a patient object
            Patient patient = new Patient("John", "Doe", 1234, "john.doe@example.com", "password");
    
            // Test the setters
            patient.setNotTakenProperly(true);
            assertTrue(patient.getNotTakenProperly());
    
            patient.setFinishedPrescription(true);
            assertTrue(patient.finishMedication());
        }
    }

  

