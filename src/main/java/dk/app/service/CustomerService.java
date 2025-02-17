package dk.app.service;

import dk.app.model.Customer;
import dk.app.model.RealCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Customer> getCustomers() {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .collect(Collectors.toList());
    }
    public List<Customer> getCustomersByName(String name) {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersByFamily(String family) {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer instanceof RealCustomer)
                .map(customer -> (RealCustomer) customer)
                .filter(realCustomer -> realCustomer.getFamily().equalsIgnoreCase(family))
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(Integer id) {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer.getId().equals(id))
                .findFirst().get();
    }
    public void deleteCustomer(Integer id) {
        customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer.getId().equals(id))
                .forEach(customer -> customer.setDeleted(true));
    }

    public List<Customer> getAllDeletedCustomers(){
        return customers.stream()
                .filter(customer -> customer.getDeleted())
                .collect(Collectors.toList());
    }
}
