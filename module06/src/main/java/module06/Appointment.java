//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

import java.util.Date; // Imports the Date class for handling date and time

// Represents an appointment with an ID, date, and description
public class Appointment {
    // Unique identifier for the appointment
    private String appointmentId;

    // Date and time of the appointment
    private Date appointmentDate;

    // Brief description of the appointment
    private String description;

    // Constructor for initializing an Appointment object with ID, date, and description
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        this.appointmentId = appointmentId;      // Sets the appointment ID
        this.appointmentDate = appointmentDate;   // Sets the date of the appointment
        this.description = description;           // Sets the description of the appointment
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
}
