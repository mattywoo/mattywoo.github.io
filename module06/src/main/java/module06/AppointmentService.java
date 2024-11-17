//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

import java.util.HashMap; // Imports HashMap for storing appointments by ID
import java.util.Map; // Imports Map interface for the appointments collection

// Manages a collection of Appointment objects, allowing addition, deletion, and retrieval
public class AppointmentService {

    // Stores appointments with their IDs as keys for quick access
    private Map<String, Appointment> appointments;

    // Constructor initializes the appointments map
    public AppointmentService() {
        this.appointments = new HashMap<>(); // Creates a new HashMap to store appointments
    }

    // Adds an appointment to the collection, using the appointment ID as the key
    public void addAppointment(Appointment appointment) {
        appointments.put(appointment.getAppointmentId(), appointment); // Adds the appointment to the map
    }

    // Deletes an appointment from the collection by its ID
    public void deleteAppointment(String appointmentId) {
        appointments.remove(appointmentId); // Removes the appointment with the specified ID
    }

    // Returns the entire map of appointments
    public Map<String, Appointment> getAppointments() {
        return appointments; // Provides access to the stored appointments
    }
}
