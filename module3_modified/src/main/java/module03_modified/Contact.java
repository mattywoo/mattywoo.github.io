//Cruz Matthew 11/16/2024

package module03_modified; // Defines the package where the class resides

import java.util.Date; // Import Date class for managing reminder times

// Represents a contact with an ID, first name, last name, phone number, and address
public class Contact {

    // Unique identifier for the contact
    private String contactID;

    // First name of the contact
    private String firstName;

    // Last name of the contact
    private String lastName;

    // Contact's phone number
    private String phone;

    // Contact's address
    private String address;

    // Reminder notification time for follow-up actions
    private Date reminderTime;

    // Constructor initializes a Contact object with ID, first name, last name, phone, and address
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        this.contactID = contactID;   // Sets the contact ID
        this.firstName = firstName;   // Sets the contact's first name
        this.lastName = lastName;     // Sets the contact's last name
        this.phone = phone;           // Sets the contact's phone number
        this.address = address;       // Sets the contact's address
    }

    // Returns the contact ID
    public String getContactID() {
        return contactID;
    }

    // Returns the contact's first name
    public String getFirstName() {
        return firstName;
    }

    // Returns the contact's last name
    public String getLastName() {
        return lastName;
    }

    // Returns the contact's phone number
    public String getPhone() {
        return phone;
    }

    // Returns the contact's address
    public String getAddress() {
        return address;
    }

    // Sets a reminder time for follow-up actions
    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    // Returns the reminder time for follow-up actions
    public Date getReminderTime() {
        return reminderTime;
    }

    // Checks if the reminder is set
    public boolean hasReminder() {
        return reminderTime != null;
    }

    // Updates for new phone number
	public void setPhone(String newPhoneNumber) {
		this.phone = newPhoneNumber;
		
	}

}
