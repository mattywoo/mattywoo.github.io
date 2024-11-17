//Cruz Matthew 11/16/2024
package module3_modified; // Defines the package where the class resides

import org.junit.jupiter.api.Test; // Imports the JUnit Test annotation for unit testing

import module03_modified.Contact;
import module03_modified.ContactService;

import static org.junit.jupiter.api.Assertions.*; // Imports JUnit assertions for test validation

// Test class for the Contact class
public class ContactTest {

    // Tests the initialization of a Contact object and verifies that its fields are set correctly
    @Test
    public void testContactInitialization() {
        // Creates a Contact object with specified ID, first name, last name, phone, and address
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Asserts that the contact ID matches the expected value
        assertEquals("1234567890", contact.getContactID());

        // Asserts that the first name matches the expected value
        assertEquals("John", contact.getFirstName());

        // Asserts that the last name matches the expected value
        assertEquals("Doe", contact.getLastName());

        // Asserts that the phone number matches the expected value
        assertEquals("1234567890", contact.getPhone());

        // Asserts that the address matches the expected value
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test to verify that a contact's phone number can be updated correctly
    @Test
    public void testUpdatePhoneNumber() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Update the phone number
        contact.setPhone("0987654321");

        // Asserts that the phone number has been updated to the new value
        assertEquals("0987654321", contact.getPhone());
    }

    // Test to verify that the getContact method in ContactService works correctly
    @Test
    public void testGetContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        // Creating a ContactService instance to test the getContact method
        ContactService contactService = new ContactService();
        contactService.addContact(contact);  // Add contact to the service

        // Retrieve the contact using the ID and check if it matches the expected contact
        Contact retrievedContact = contactService.getContact("1234567890");

        // Asserts that the retrieved contact matches the original contact
        assertEquals(contact, retrievedContact);
    }
}
