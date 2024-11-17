//Cruz Matthew 11/16/2024

package module3_modified; // Defines the package where the class resides

import org.junit.jupiter.api.Test; // Imports JUnit Test annotation for unit testing

import module03_modified.Appointment; // Imports the Appointment class

import static org.junit.jupiter.api.Assertions.*; // Imports JUnit assertions for test validation

import java.util.Date; // Imports Date class for handling date and time
import java.util.function.BooleanSupplier; // Imports the BooleanSupplier interface

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

    // Tests setting the description of an Appointment
    @Test
    public void testSetDescription() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Update the description
        appointment.setDescription("Updated Appointment Description");

        // Assert the updated description
        assertEquals("Updated Appointment Description", appointment.getDescription());
    }

    // Tests setting the appointment date of an Appointment
    @Test
    public void testSetAppointmentDate() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Update the appointment date
        Date updatedDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 48); // 48 hours from now
        appointment.setAppointmentDate(updatedDate);

        // Assert the updated date
        assertEquals(updatedDate, appointment.getAppointmentDate());
    }

    // Tests marking the appointment as completed
    @Test
    public void testSetCompleted() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Mark the appointment as completed
        appointment.setCompleted(true);

        // Assert that the appointment is marked as completed
        assertTrue(appointment.isCompleted());

        // Mark the appointment as not completed
        appointment.setCompleted(false);

        // Assert that the appointment is not completed
        assertFalse(appointment.isCompleted());
    }

    // Tests the getId method
    @Test
    public void testGetId() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Assert the appointment ID
        assertEquals("A123456789", appointment.getId());
    }

    // Tests the isCompleted method (using the BooleanSupplier)
    @Test
    public void testIsCompleted() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Assert that the appointment is not completed initially
        BooleanSupplier isCompleted = appointment.isCompleted();
        assertFalse(isCompleted.getAsBoolean());

        // Mark as completed and assert again
        appointment.setCompleted(true);
        assertTrue(isCompleted.getAsBoolean());
    }
}
