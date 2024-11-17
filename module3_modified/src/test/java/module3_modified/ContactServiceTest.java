//Cruz Matthew 11/16/2024

package module3_modified; // Defines the package for the class

import org.junit.jupiter.api.Test; // Imports the Test annotation for JUnit tests

import module03_modified.Contact; // Imports the Contact class
import module03_modified.ContactService; // Imports the ContactService class

import static org.junit.jupiter.api.Assertions.*; // Imports assertions for test validation

// Test class for the ContactService class
public class ContactServiceTest {

    // Test to verify that a contact can be added to the ContactService
    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService(); // Creates a new ContactService instance
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"); // Creates a new Contact instance
        contactService.addContact(contact); // Adds the contact to the ContactService

        // Asserts that the contact ID "1234567890" exists in the contacts map after addition
        assertTrue(contactService.getContacts().containsKey("1234567890"));
    }

    // Test to verify that a contact can be deleted from the ContactService
    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService(); // Creates a new ContactService instance
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"); // Creates a new Contact instance
        contactService.addContact(contact); // Adds the contact to the ContactService
        contactService.deleteContact("1234567890"); // Deletes the contact by its ID

        // Asserts that the contact ID "1234567890" no longer exists in the contacts map after deletion
        assertFalse(contactService.getContacts().containsKey("1234567890"));
    }

    // Test to verify that a contact's details can be updated in the ContactService
    @Test
    public void testUpdateContact() {
        ContactService contactService = new ContactService(); // Creates a new ContactService instance
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"); // Creates a new Contact instance
        contactService.addContact(contact); // Adds the contact to the ContactService

        // Updates the contact's first name to "Jane" while keeping other details the same
        contactService.updateContact("1234567890", "Jane", "Doe", "1234567890", "123 Main St");

        // Asserts that the contact's first name is updated to "Jane"
        assertEquals("Jane", contactService.getContacts().get("1234567890").getFirstName());
    }

    // Test to verify that a contact's phone number can be updated in the ContactService
    @Test
    public void testUpdatePhoneNumber() {
        ContactService contactService = new ContactService(); // Creates a new ContactService instance
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"); // Creates a new Contact instance
        contactService.addContact(contact); // Adds the contact to the ContactService

        // Updates the contact's phone number to a new number
        contactService.updatePhoneNumber("1234567890", "0987654321");

        // Asserts that the contact's phone number is updated to "0987654321"
        assertEquals("0987654321", contactService.getContacts().get("1234567890").getPhone());
    }

    // Test to verify that a contact can be retrieved from the ContactService by ID
    @Test
    public void testGetContactById() {
        ContactService contactService = new ContactService(); // Creates a new ContactService instance
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"); // Creates a new Contact instance
        contactService.addContact(contact); // Adds the contact to the ContactService

        // Retrieve the contact by ID and assert the contact's first name is "John"
        Contact retrievedContact = contactService.getContact("1234567890");
        assertEquals("John", retrievedContact.getFirstName());
    }
}
