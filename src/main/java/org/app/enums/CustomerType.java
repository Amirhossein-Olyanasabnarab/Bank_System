package org.app.enums;

public enum CustomerType {
    REAL_CUSTOMER(1),
    LEGAL_CUSTOMER(2);


    private final int value;
    CustomerType(int value) {
        this.value = value;
    }

    public static CustomerType fromValue(int value) {
        for (CustomerType type : CustomerType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
