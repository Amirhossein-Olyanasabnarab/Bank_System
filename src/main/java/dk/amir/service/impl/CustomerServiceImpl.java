package dk.amir.service.impl;

import dk.amir.model.Customer;
import dk.amir.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomerById(Integer id) {
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {

    }

    @Override
    public List<Customer> getDeletedCustomers() {
        return List.of();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public List<Customer> getActiveCustomers() {
        return List.of();
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return List.of();
    }

    @Override
    public List<Customer> searchCustomerByFamily(String family) {
        return List.of();
    }
}
