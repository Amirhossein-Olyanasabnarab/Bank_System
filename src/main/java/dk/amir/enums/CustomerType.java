package dk.amir.enums;

/**
 * Enum representing the type of  customer.
 * It can be either a REAL person or a LEGAL entity.
 */
public enum CustomerType {

    /** Represents an individual (real) customer. */
    REAL(1),
    /** Represents a legal entity (company, organization, etc.). */
    LEGAL(2);


    private final int value;



    /**
     * Constructor for CustomerType enum.
     *
     * @param value The integer value representing the customer type.
     */
    CustomerType(int value) {
        this.value = value;
    }



    /**
     * Retrieves the corresponding CustomerType based on the integer value.
     *
     * @param value The integer value of the customer type.
     * @return The matching CustomerType or {@code null} if not found.
     */
    public static CustomerType fromValue(int value) {
        for (CustomerType customerType : values()) {
            if (customerType.value == value) {
                return customerType;
            }
        }
        return null;
    }
}
