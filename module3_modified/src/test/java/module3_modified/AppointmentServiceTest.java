//Cruz Matthew 11/16/2024

package module3_modified; // Defines the package where the class resides

import org.junit.jupiter.api.BeforeEach; // Import JUnit annotations for setup
import org.junit.jupiter.api.Test; // Imports JUnit Test annotation for unit testing

import module03_modified.Appointment;
import module03_modified.AppointmentService;

import static org.junit.jupiter.api.Assertions.*; // Imports JUnit assertions for test validation

import java.util.Date; // Imports Date class for handling date and time
import java.util.List; // Imports List interface for storing appointment data
import java.util.Map;

// Test class for the AppointmentService class
public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        // Initializes a new AppointmentService before each test
        appointmentService = new AppointmentService();
    }

    // Tests adding an appointment to the AppointmentService
    @Test
    public void testAddAppointment() {
        // Sets the appointment date to 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Retrieves the list of appointments from the service
        @SuppressWarnings("unchecked")
		List<Appointment> appointments = (List<Appointment>) appointmentService.getAppointments();

        // Asserts that there is one appointment in the service
        assertEquals(1, appointments.size());

        // Asserts that the list contains the appointment with the specified ID
        assertTrue(appointments.stream().anyMatch(a -> a.getId().equals("A123456789")));
    }

    // Tests deleting an appointment from the AppointmentService
    @Test
    public void testDeleteAppointment() {
        // Sets the appointment date to 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Retrieves the list of appointments from the service
        Map<String, Appointment> appointments = appointmentService.getAppointments();

        // Asserts that there is one appointment in the service before deletion
        assertEquals(1, appointments.size());

        // Deletes the appointment from the service by ID
        appointmentService.deleteAppointment("A123456789");

        // Asserts that the list of appointments is empty after deletion
        assertEquals(0, appointmentService.getAppointments().size());
    }

    // Tests updating the appointment description
    @Test
    public void testUpdateAppointmentDescription() {
        // Sets the appointment date to 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Updates the appointment description
        appointmentService.updateAppointmentDescription("A123456789", "Updated Appointment Description");

        // Retrieves the appointment and asserts the updated description
        Appointment updatedAppointment = appointmentService.getAppointment("A123456789");
        assertEquals("Updated Appointment Description", updatedAppointment.getDescription());
    }

    // Tests updating the appointment date
    @Test
    public void testUpdateAppointmentDate() {
        // Sets the appointment date to 24 hours from the current time
        Date initialDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        Date updatedDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 48); // 48 hours from now

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", initialDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Updates the appointment date
        appointmentService.updateAppointmentDate("A123456789", updatedDate);

        // Retrieves the updated appointment and asserts the new date
        Appointment updatedAppointment = appointmentService.getAppointment("A123456789");
        assertEquals(updatedDate, updatedAppointment.getAppointmentDate());
    }

    // Tests retrieving appointments by date range
    @Test
    public void testGetAppointmentsByDateRange() {
        // Sets appointment dates
        Date appointmentDate1 = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 24 hours from now
        Date appointmentDate2 = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 48); // 48 hours from now

        // Creates appointment objects with specific IDs, dates, and descriptions
        Appointment appointment1 = new Appointment("A123456789", appointmentDate1, "Test Appointment 1");
        Appointment appointment2 = new Appointment("A123456790", appointmentDate2, "Test Appointment 2");

        // Adds appointments to the service
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);

        // Defines the date range for filtering appointments
        Date startDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60); // 1 hour from now
        Date endDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 36); // 36 hours from now

        // Retrieves appointments within the date range
        List<Appointment> filteredAppointments = appointmentService.getAppointmentsByDateRange(startDate, endDate);

        // Asserts that the correct appointments are retrieved
        assertEquals(1, filteredAppointments.size());
        assertTrue(filteredAppointments.stream().anyMatch(a -> a.getId().equals("A123456789")));
    }

    // Tests checking the status of an appointment (if applicable)
    @Test
    public void testMarkAppointmentAsCompleted() {
        // Sets the appointment date to 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Creates an Appointment object with a specific ID, date, and description
        Appointment appointment = new Appointment("A123456789", appointmentDate, "Test Appointment");

        // Adds the appointment to the service
        appointmentService.addAppointment(appointment);

        // Marks the appointment as completed
        appointmentService.markAppointmentAsCompleted("A123456789");

        // Retrieves the updated appointment and asserts it is completed
        Appointment updatedAppointment = appointmentService.getAppointment("A123456789");
        assertTrue(((Appointment) updatedAppointment).isCompleted());
    }
}
