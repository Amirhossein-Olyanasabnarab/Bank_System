package dk.amir.service.impl;

import dk.amir.model.Customer;
import dk.amir.model.RealCustomer;
import dk.amir.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation of the CustomerService interface.
 * This class manages a list of customers, providing functionalities such as
 * adding, deleting, and searching customers.
 *
 * It follows the Singleton design pattern to ensure only one instance of the service exists.
 */
public class CustomerServiceImpl implements CustomerService {

    // Singleton instance of CustomerServiceImpl
    private static final CustomerServiceImpl INSTANCE;

    // Private constructor to prevent instantiation
    private CustomerServiceImpl(){}

    /**
     * Returns the singleton instance of CustomerServiceImpl.
     *
     * @return the singleton instance of CustomerServiceImpl.
     */
    public static CustomerServiceImpl getInstance(){
        return INSTANCE;
    }

    // Static block to initialize the singleton instance
    static {
        INSTANCE = new CustomerServiceImpl();
    }

    private List<Customer> customers = new ArrayList<>();

    /**
     * Adds a new customer to the list.
     *
     * @param customer the customer to be added.
     */
    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }


    /**
     * Retrieves a customer by their ID, ensuring the customer is not marked as deleted.
     *
     * @param id the ID of the customer.
     * @return the customer with the given ID.
     */
    @Override
    public Customer getCustomerById(Integer id) {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer.getId().equals(id))
                .findFirst().get(); // Potential NoSuchElementException if not found
    }


    /**
     * Marks a customer as deleted by setting the "deleted" flag to true.
     *
     * @param id the ID of the customer to be deleted.
     */
    @Override
    public void deleteCustomer(Integer id) {
        customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer.getId().equals(id))
                .forEach(customer -> customer.setDeleted(true));
    }


    /**
     * Retrieves a list of all customers who have been marked as deleted.
     *
     * @return a list of deleted customers.
     */
    @Override
    public List<Customer> getDeletedCustomers() {
        return customers.stream()
                .filter(customer -> customer.getDeleted())
                .collect(Collectors.toList());
    }


    /**
     * Retrieves a list of all customers, including both active and deleted ones.
     *
     * @return a list of all customers.
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }


    /**
     * Retrieves a list of active (non-deleted) customers.
     *
     * @return a list of active customers.
     */
    @Override
    public List<Customer> getActiveCustomers() {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .collect(Collectors.toList());
    }


    /**
     * Searches for active customers by their name (case-insensitive).
     *
     * @param name the name of the customer to search for.
     * @return a list of customers matching the given name.
     */
    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }


    /**
     * Searches for active customers who are instances of RealCustomer by their family name (case-insensitive).
     *
     * @param family the family name to search for.
     * @return a list of RealCustomers matching the given family name.
     */
    @Override
    public List<Customer> searchCustomerByFamily(String family) {
        return customers.stream()
                .filter(customer -> !customer.getDeleted())
                .filter(customer -> customer instanceof RealCustomer) // Ensure type is RealCustomer
                .map(customer -> (RealCustomer) customer) // Cast to RealCustomer
                .filter(realCustomer -> realCustomer.getFamily().equalsIgnoreCase(family))
                .collect(Collectors.toList());
    }
}
