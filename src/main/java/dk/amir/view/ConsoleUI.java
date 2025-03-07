package dk.amir.view;

import dk.amir.enums.CustomerType;
import dk.amir.model.Customer;
import dk.amir.service.CustomerService;
import dk.amir.service.impl.CustomerServiceImpl;
import dk.amir.util.ScannerWrapper;
import dk.amir.view.component.AbstractCustomerUI;

import java.util.List;
import java.util.function.Function;

public class ConsoleUI implements AutoCloseable{
    private final ScannerWrapper scannerWrapper;
    private final CustomerService customerService;
    public ConsoleUI(){
        this.scannerWrapper = ScannerWrapper.getInstance();
        this.customerService = CustomerServiceImpl.getInstance();
    }

    public void startMenu(){
        int choice;
        do {
            printMenu();
            choice = scannerWrapper.getMessage("Enter your choice:", Integer::valueOf);
            switch (choice) {
                case 0:
                    System.out.println("Exit....!!!");
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    showAllCustomers();
                    break;
                case 3:
                    deleteCustomerById();
                    break;
                case 4:
                    editCustomerById();
                    break;
                case 5:
                    getCustomerById();
                    break;
                case 6:
                    getCustomerByName();
                    break;
                case 7:
                    getCustomerByFamily();
                    break;
                case 8:
                    getAllDeletedCustomers();
                    break;
                case 9:
                    getAllCustomersAsActiveOrNonActive();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice != 0);
    }

    private void getAllCustomersAsActiveOrNonActive() {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void getAllDeletedCustomers() {
        List<Customer> customers = customerService.getDeletedCustomers();
        if(customers.isEmpty()){
            System.out.println("No active customers");
        }else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private void getCustomerByFamily() {
        String family = scannerWrapper.getMessage("Enter family name:", Function.identity());
        List<Customer> customers = customerService.searchCustomerByFamily(family);
        customers.forEach(System.out::println);
    }

    private void getCustomerByName() {
        String name = scannerWrapper.getMessage("Enter your customer name:", Function.identity());
        List<Customer> customers = customerService.searchCustomerByName(name);
        customers.forEach(System.out::println);
    }

    private void getCustomerById() {
        Integer customerId = scannerWrapper.getMessage("Enter customer id:", Integer::valueOf);
        Customer customer = customerService.getCustomerById(customerId);
        System.out.println(customer);
    }

    private void editCustomerById() {
        Integer customerId = scannerWrapper.getMessage("Enter customer id:", Integer::valueOf);
        Customer customer = customerService.getCustomerById(customerId);
        System.out.println(customer);

        AbstractCustomerUI
                .fromCustomerType(customer.getType())
                .editCustomer(customer);
    }

    private void deleteCustomerById() {
        Integer customerId = scannerWrapper.getMessage("Enter customer id:", Integer::valueOf);
        customerService.deleteCustomer(customerId);
    }

    private void showAllCustomers() {
        List<Customer> customers = customerService.getActiveCustomers();
        if(customers.isEmpty()){
            System.out.println("No active customers");
        }
        customers.forEach(System.out::println);
    }

    private void addCustomer() {
        System.out.println("Customer Type => ");
        System.out.println("1. Real Customer");
        System.out.println("2. Legal Customer");
        int choice = scannerWrapper.getMessage("Please enter your customer type:", Integer::valueOf);

        Customer customer = AbstractCustomerUI
                .fromCustomerType(CustomerType.fromValue(choice))
                .generateCustomer();

        customerService.addCustomer(customer);
    }

    private void printMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("1. add Customer");
        System.out.println("2. show all customers");
        System.out.println("3. delete customer");
        System.out.println("4. edit customer by id");
        System.out.println("5. show customer by id");
        System.out.println("6. show customer by name");
        System.out.println("7. show customer by family");
        System.out.println("8. show all deleted customers");
        System.out.println("9. show active & non-active customers");
        System.out.println("0. Exit ");
    }
    @Override
    public void close()  {
        scannerWrapper.close();
    }
}
