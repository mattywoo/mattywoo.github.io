//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

import org.junit.jupiter.api.Test; // Imports the JUnit Test annotation for unit testing
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
}