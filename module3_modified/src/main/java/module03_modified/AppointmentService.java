//Cruz Matthew 11/16/2024

package module03_modified; // Defines the package where the class resides

import java.util.Date;
import java.util.HashMap; // Imports HashMap for storing appointments by ID
import java.util.List;
import java.util.Map; // Imports Map interface for the appointments collection
import java.util.Timer; // Imports Timer for scheduling notifications
import java.util.TimerTask; // Imports TimerTask for defining notification behavior
import java.util.ArrayList; // For storing the filtered list of appointments

// Manages a collection of Appointment objects, allowing addition, deletion, and retrieval
public class AppointmentService {

    // Stores appointments with their IDs as keys for quick access
    private Map<String, Appointment> appointments;

    // Constructor initializes the appointments map
    public AppointmentService() {
        this.appointments = new HashMap<>(); // Creates a new HashMap to store appointments
    }

    // Adds an appointment to the collection and schedules its reminder
    public void addAppointment(Appointment appointment) {
        appointments.put(appointment.getAppointmentId(), appointment); // Adds the appointment to the map

        // Schedule a reminder for the added appointment, if applicable
        scheduleReminder(appointment);
    }

    // Deletes an appointment from the collection by its ID and cancels its reminder
    public void deleteAppointment(String appointmentId) {
        Appointment appointment = appointments.remove(appointmentId); // Removes the appointment with the specified ID
        if (appointment != null) {
            System.out.println("Appointment with ID " + appointmentId + " has been deleted.");
        } else {
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    }

    // Returns the entire map of appointments
    public Map<String, Appointment> getAppointments() {
        return appointments; // Provides access to the stored appointments
    }

    // Schedules a reminder for a specific appointment
    private void scheduleReminder(final Appointment appointment) {
        long reminderTime = appointment.getReminderTime(); // Get the reminder time in milliseconds
        if (reminderTime > 0) { // Only schedule if a reminder time is set
            Timer timer = new Timer();
            long timeUntilReminder = appointment.getAppointmentDate().getTime() - System.currentTimeMillis() - reminderTime;

            // Ensure the reminder is in the future
            if (timeUntilReminder > 0) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Reminder: Your appointment \"" + appointment.getDescription() +
                                "\" is scheduled at " + appointment.getAppointmentDate());
                    }
                }, timeUntilReminder);
            } else {
                System.out.println("Reminder for appointment \"" + appointment.getDescription() +
                        "\" could not be scheduled because the time has already passed.");
            }
        }
    }

 // Updates the description of an appointment given its ID and the new description
    public void updateAppointmentDescription(String appointmentId, String newDescription) {
        // Retrieve the appointment using the provided ID
        Appointment appointment = appointments.get(appointmentId);

        // Check if the appointment exists
        if (appointment != null) {
            // Update the description of the appointment
            appointment.setDescription(newDescription);
            System.out.println("Appointment ID " + appointmentId + " description has been updated to: " + newDescription);
        } else {
            // Handle the case where the appointment doesn't exist
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    }

 // Retrieves an appointment by its ID
    public Appointment getAppointment(String appointmentId) {
        // Retrieve the appointment using the provided ID
        return appointments.get(appointmentId); // Return the appointment, or null if not found
    }

 // Updates the date of an existing appointment based on appointment ID
    public void updateAppointmentDate(String appointmentId, Date updatedDate) {
        // Retrieve the appointment using its ID
        Appointment appointment = appointments.get(appointmentId);

        if (appointment != null) {
            // If the appointment exists, update its date
            appointment.setAppointmentDate(updatedDate); // Use the set method to update the date
            System.out.println("Appointment with ID " + appointmentId + " has been updated to the new date.");
        } else {
            // If the appointment doesn't exist, print an error message
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    }

    public List<Appointment> getAppointmentsByDateRange(Date startDate, Date endDate) {
        List<Appointment> filteredAppointments = new ArrayList<>(); // List to store appointments within the date range

        // Iterate over all appointments
        for (Appointment appointment : appointments.values()) {
            Date appointmentDate = appointment.getAppointmentDate(); // Get the appointment date

            // Check if the appointment's date is within the specified range
            if (appointmentDate.after(startDate) && appointmentDate.before(endDate)) {
                filteredAppointments.add(appointment); // Add to the list if it matches the criteria
            }
        }

        return filteredAppointments; // Return the list of filtered appointments
    }

    // Marks an appointment as completed by its ID
    public void markAppointmentAsCompleted(String appointmentId) {
        Appointment appointment = appointments.get(appointmentId); // Retrieve the appointment by ID
        if (appointment != null) {
            appointment.setCompleted(true); // Set the appointment as completed
            System.out.println("Appointment with ID " + appointmentId + " has been marked as completed.");
        } else {
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    }
}