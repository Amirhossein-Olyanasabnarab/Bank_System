package dk.amir.service;

import dk.amir.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(Integer id);
    void deleteCustomer(Integer id);
    List<Customer> getDeletedCustomers();
    List<Customer> getAllCustomers(); //active and de-active
    List<Customer> getActiveCustomers();
    List<Customer> searchCustomerByName(String name);
    List<Customer> searchCustomerByFamily(String family);
}
