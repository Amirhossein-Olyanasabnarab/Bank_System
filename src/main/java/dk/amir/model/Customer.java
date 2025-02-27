package dk.amir.model;

import dk.amir.enums.CustomerType;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Represents a generic customer in the system.
 * This class is abstract and serves as a base for specific customer types.
 */
public abstract class Customer {

    /** Atomic counter for generating unique customer IDs. */
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    /** Unique identifier for the customer. */
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private final CustomerType type;
    private  Boolean deleted;


    /**
     * Constructs a new Customer with the given details.
     * The customer is assigned a unique ID automatically.
     *
     * @param fullName The full name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param email The email address of the customer.
     * @param type The type of the customer (REAL or LEGAL).
     */
    public Customer(String fullName, String phoneNumber, String email, CustomerType type) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.fullName = capitalizeFirstLetter(fullName);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
        this.deleted = false;
    }

    public Integer getId() {
        return id;
    }

    public CustomerType getType() {
        return type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = capitalizeFirstLetter(fullName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }



    /**
     * Capitalizes the first letter of a given string.
     *
     * @param string The input string.
     * @return The string with the first letter capitalized.
     */
    private String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
