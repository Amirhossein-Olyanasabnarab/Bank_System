package dk.app.model;

import dk.app.enums.CustomerType;

public class RealCustomer extends Customer {

    private String family;
    private String mobilePhoneNumber;

    public RealCustomer(String name, String phoneNumber) {
        super(name, phoneNumber, CustomerType.REAL_CUSTOMER);
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = capitalizeFirstLetter(family);
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public String toString() {
        return "RealCustomer{ " +
                super.toString() +
                ", family='" + family + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                '}';
    }
}
