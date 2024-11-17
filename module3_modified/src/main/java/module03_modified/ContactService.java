//Cruz Matthew 11/16/2024

package module03_modified; // Defines the package where the class resides

import java.util.Date; // Imports Date for managing reminders
import java.util.HashMap; // Imports HashMap for storing contacts
import java.util.Map; // Imports Map interface

// Service class to manage a collection of Contact objects
public class ContactService {

    // Map to store contacts, using contact ID as the key
    private Map<String, Contact> contacts;

    // Constructor initializes the contacts map
    public ContactService() {
        this.contacts = new HashMap<>(); // Creates an empty HashMap to hold contacts
    }

    /**
     * Adds a new contact to the contacts map.
     *
     * @param contact Contact object to be added
     */
    public void addContact(Contact contact) {
        contacts.put(contact.getContactID(), contact); // Adds the contact using its ID as the key
    }

    /**
     * Deletes a contact from the contacts map based on contact ID.
     *
     * @param contactID ID of the contact to be deleted
     */
    public void deleteContact(String contactID) {
        contacts.remove(contactID); // Removes the contact by its ID
    }

    /**
     * Updates an existing contact's information if it exists.
     *
     * @param contactID ID of the contact to be updated
     * @param firstName New first name for the contact
     * @param lastName New last name for the contact
     * @param phone New phone number for the contact
     * @param address New address for the contact
     */
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        // Checks if the contact exists before updating
        if (contacts.containsKey(contactID)) {
            // Updates the existing contact fields instead of creating a new object
            Contact contact = contacts.get(contactID);
            if (contact != null) {
                contact = new Contact(contactID, firstName, lastName, phone, address);
                contacts.put(contactID, contact); // Updates the contact in the map
            }
        }
    }

    /**
     * Sets a reminder for a specific contact.
     *
     * @param contactID ID of the contact for which the reminder is being set
     * @param reminderTime Date and time of the reminder
     * @return true if the reminder was set successfully, false otherwise
     */
    public boolean setReminder(String contactID, Date reminderTime) {
        if (contacts.containsKey(contactID)) {
            Contact contact = contacts.get(contactID);
            contact.setReminderTime(reminderTime);
            return true; // Reminder successfully set
        }
        return false; // Contact not found
    }

    /**
     * Retrieves a contact's reminder time.
     *
     * @param contactID ID of the contact whose reminder time is being retrieved
     * @return Date of the reminder or null if the contact or reminder doesn't exist
     */
    public Date getReminder(String contactID) {
        if (contacts.containsKey(contactID)) {
            Contact contact = contacts.get(contactID);
            return contact.getReminderTime(); // Return the reminder time
        }
        return null; // Contact or reminder not found
    }

    /**
     * Retrieves all contacts in the contacts map.
     *
     * @return Map of contacts, with contact IDs as keys
     */
    public Map<String, Contact> getContacts() {
        return contacts; // Returns the current map of contacts
    }

    /**
     * Checks if a contact exists in the map by ID.
     *
     * @param contactID ID of the contact to check
     * @return true if the contact exists, false otherwise
     */
    public boolean contactExists(String contactID) {
        return contacts.containsKey(contactID); // Returns true if the contact exists
    }

    public void updatePhoneNumber(String contactId, String newPhoneNumber) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setPhone(newPhoneNumber); // Assuming setPhoneNumber is implemented in Contact class
        } else {
            System.out.println("Contact not found!");
        }
    }

	public Contact getContact(String string) {
		return null;
	}
}