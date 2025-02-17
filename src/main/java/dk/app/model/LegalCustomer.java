package dk.app.model;

import dk.app.enums.CustomerType;

public class LegalCustomer extends Customer{
    private String companyName;
    private String fax;

    public LegalCustomer(String name, String phoneNumber) {
        super(name, phoneNumber, CustomerType.LEGAL_CUSTOMER);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = capitalizeFirstLetter(companyName);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

    @Override
    public String toString() {
        return "LegalCustomer{ " +
                super.toString() +
                ", companyName='" + companyName + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
