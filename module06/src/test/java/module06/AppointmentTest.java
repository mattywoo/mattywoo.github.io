//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

import org.junit.jupiter.api.Test; // Imports JUnit Test annotation for unit testing
import static org.junit.jupiter.api.Assertions.*; // Imports JUnit assertions for test validation

import java.util.Date; // Imports Date class for handling date and time

// Test class for the Appointment class
public class AppointmentTest {

    // Tests the creation of an Appointment object
    @Test
    public void testAppointmentCreation() {
        // Sets appointmentDate to 24 hours from the current time (i.e., tomorrow)
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Asserts that the appointment object is not null
        assertNotNull(appointment);

        // Asserts that the appointment ID matches the expected ID
        assertEquals("A123456789", appointment.getAppointmentId());

        // Asserts that the appointment date matches the expected date
        assertEquals(appointmentDate, appointment.getAppointmentDate());

        // Asserts that the description matches the expected description
        assertEquals("Test Appointment", appointment.getDescription());
    }
}
