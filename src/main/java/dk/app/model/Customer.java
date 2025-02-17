package dk.app.model;

import dk.app.enums.CustomerType;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Customer {
    private final static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private Integer id;
    private String name;
    private String phoneNumber;
    private final CustomerType customerType;
    private Boolean deleted;

    public Customer(String name, String phoneNumber, CustomerType customerType) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = capitalizeFirstLetter(name);
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        this.deleted = false;
    }

    public Integer getId() {
        return id;
    }
    public CustomerType getCustomerType() {
        return customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = capitalizeFirstLetter(name);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerType ;
    }
}
