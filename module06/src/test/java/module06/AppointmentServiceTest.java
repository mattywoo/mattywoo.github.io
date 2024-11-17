//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

import org.junit.jupiter.api.Test; // Imports JUnit Test annotation for unit testing
import static org.junit.jupiter.api.Assertions.*; // Imports JUnit assertions for test validation

import java.util.Date; // Imports Date class for handling date and time
import java.util.Map; // Imports Map interface for storing appointment data

// Test class for the AppointmentService class
public class AppointmentServiceTest {

    // Tests adding an appointment to the AppointmentService
    @Test
    public void testAddAppointment() {
        // Creates an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();

        // Sets the appointment date to 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Retrieves the map of appointments from the service
        Map<String, Appointment> appointments = appointmentService.getAppointments();

        // Asserts that there is one appointment in the service
        assertEquals(1, appointments.size());

        // Asserts that the map contains the appointment with the specified ID
        assertTrue(appointments.containsKey("A123456789"));
    }

    // Tests deleting an appointment from the AppointmentService
    @Test
    public void testDeleteAppointment() {
        // Creates an instance of AppointmentService
        AppointmentService appointmentService = new AppointmentService();

        // Sets the appointment date to 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Retrieves the map of appointments from the service
        Map<String, Appointment> appointments = appointmentService.getAppointments();

        // Asserts that there is one appointment in the service before deletion
        assertEquals(1, appointments.size());

        // Deletes the appointment from the service by ID
        appointmentService.deleteAppointment("A123456789");

        // Asserts that the map of appointments is empty after deletion
        assertEquals(0, appointments.size());
    }
}

