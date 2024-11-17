//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

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
            // Creates a new Contact object with updated information and replaces the existing contact
            Contact contact = new Contact(contactID, firstName, lastName, phone, address);
            contacts.put(contactID, contact); // Updates the contact in the map
        }
    }

    /**
     * Retrieves all contacts in the contacts map.
     *
     * @return Map of contacts, with contact IDs as keys
     */
    public Map<String, Contact> getContacts() {
        return contacts; // Returns the current map of contacts
    }
}
