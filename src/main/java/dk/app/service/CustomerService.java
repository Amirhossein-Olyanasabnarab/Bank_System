package dk.app.service;

import dk.app.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    //Singleton pattern
    private static final CustomerService INSTANCE;
    public static CustomerService getInstance() {
        return INSTANCE;
    }
    static {
        INSTANCE = new CustomerService();
    }

    private CustomerService() {}

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
