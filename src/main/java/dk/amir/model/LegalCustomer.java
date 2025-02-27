package dk.amir.model;

import dk.amir.enums.CustomerType;


/**
 * Represents a legal (corporate) customer in the system.
 * This class extends the {@link Customer} class.
 */
public class LegalCustomer extends Customer{

    /** The industry in which the legal customer operates. */
    private String industry;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }


    /**
     * Returns a string representation of the LegalCustomer object.
     *
     * @return A formatted string containing customer details.
     */
    @Override
    public String toString() {
        return "LegalCustomer{ " +
                super.toString() +
                " industry='" + industry + '\'' +
                '}';
    }

    /**
     * Constructs a new LegalCustomer with the given details.
     *
     * @param name The name of the legal entity.
     * @param phoneNumber The phone number of the legal entity.
     * @param email The email address of the legal entity.
     */
    public LegalCustomer(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email, CustomerType.LEGAL);
    }
}
