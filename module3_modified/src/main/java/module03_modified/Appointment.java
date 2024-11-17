//Cruz Matthew 11/16/2024

package module03_modified; // Defines the package where the class resides

import java.util.Date; // Imports the Date class for handling date and time
import java.util.Timer; // Timer for scheduling notifications
import java.util.TimerTask; // TimerTask for defining notification behavior
import java.util.function.BooleanSupplier;

// Represents an appointment with an ID, date, and description
public class Appointment {
    // Unique identifier for the appointment
    private String appointmentId;

    // Date and time of the appointment
    private Date appointmentDate;

    // Brief description of the appointment
    private String description;

    // Reminder time in milliseconds before the appointment
    private long reminderTime; // e.g., 3600000 for 1 hour (1 hour = 3600 seconds = 3600000 milliseconds)

	private boolean completed;
	// Allows appointments to be set to completed

    // Constructor for initializing an Appointment object with ID, date, and description
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        this.appointmentId = appointmentId;      // Sets the appointment ID
        this.appointmentDate = appointmentDate;   // Sets the date of the appointment
        this.description = description;           // Sets the description of the appointment
        this.reminderTime = 0; // Default reminder time (0 = no reminder set)
    }

    // Returns the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Returns the appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Returns the description of the appointment
    public String getDescription() {
        return description;
    }

    // Sets the reminder time in milliseconds
    public void setReminderTime(long reminderTime) {
        this.reminderTime = reminderTime;
    }

    // Gets the reminder time
    public long getReminderTime() {
        return reminderTime;
    }

    // Schedules a notification for the appointment
    public void scheduleReminder() {
        if (reminderTime > 0) { // Only schedule if a reminder time is set
            Timer timer = new Timer();
            Date reminderDate = new Date(appointmentDate.getTime() - reminderTime); // Calculate the reminder time

            // Schedule a notification
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Reminder: Your appointment \"" + description + "\" is coming up at " + appointmentDate);
                }
            }, reminderDate);
        }
    }

 // Sets a new description for the appointment
    public void setDescription(String newDescription) {
        this.description = newDescription; // Updates the appointment's description
    }

 // Sets a new date for the appointment
    public void setAppointmentDate(Date updatedDate) {
        this.appointmentDate = updatedDate; // Updates the appointment's date
    }

    public Object getId() {
        return this.appointmentId; // Return the appointment ID
    }

    // Setter for completed status
    public void setCompleted(boolean completed) {
        this.completed = completed; // Updates the appointment's completed status
    }

    // Returns a BooleanSupplier to check if the appointment is completed
    public BooleanSupplier isCompleted() {
        return () -> completed; // Returns a BooleanSupplier that checks if the appointment is completed
    }
}
