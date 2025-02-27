package dk.amir.model;

import dk.amir.enums.CustomerType;


/**
 * Represents a real (individual) customer in the system.
 * This class extends the {@link Customer} class.
 */
public class RealCustomer extends Customer {

    /** The family name (surname) of the customer. */
    private String family;


    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


    /**
     * Returns a string representation of the RealCustomer object.
     *
     * @return A formatted string containing customer details.
     */
    @Override
    public String toString() {
        return "RealCustomer{ " +
                super.toString() +
                " family='" + family + '\'' +
                '}';
    }


    /**
     * Constructs a new RealCustomer with the given details.
     *
     * @param name The first name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param email The email address of the customer.
     */
    public RealCustomer(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email, CustomerType.REAL);
    }
}
