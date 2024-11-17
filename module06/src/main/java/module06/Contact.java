//Cruz Matthew 04/13/2024

package module06; // Defines the package where the class resides

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
}
