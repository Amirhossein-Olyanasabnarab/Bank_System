package dk.app.view;

import dk.app.model.Customer;
import dk.app.model.LegalCustomer;
import dk.app.model.RealCustomer;
import dk.app.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements AutoCloseable{
    private final Scanner scanner;
    private final CustomerService customerService;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        customerService = CustomerService.getInstance();
    }

    public void startMenu(){
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    printAllCustomers();
                    break;
                case 3:
                    searchCustomerByName();
                    break;
                case 4:
                    searchCustomerByFamily();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice != 0);
    }

    private void searchCustomerByFamily() {
        String family = getUserInput("Enter family name");
        List<Customer> customers = customerService.getCustomersByFamily(family);
        if (customers.isEmpty()){
            System.out.println("Customer not found");
        }
        customers.forEach(System.out::println);
    }

    private void searchCustomerByName() {
        String name = getUserInput("Please enter your name: ");
        List<Customer> customers = customerService.getCustomersByName(name);
        if (customers.isEmpty()){
            System.out.println("Customer not found");
        }
        customers.forEach(System.out::println);
    }

    private void printAllCustomers() {
        List<Customer> getAllCustomers = customerService.getCustomers();
        if(getAllCustomers.isEmpty()){
            System.out.println("No customers found");
        }
        System.out.println("All Customers => ");
        for (Customer customer : getAllCustomers) {
            System.out.println(customer);
        }
    }

    private void addNewCustomer() {
        System.out.println("Please choose a customer type:");
        System.out.println("1- Real Customer");
        System.out.println("2- Legal Customer");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            String name = getUserInput("Please enter your name: ");
            String family = getUserInput("Please enter your family: ");
            String phone = getUserInput("Please enter your phone number: ");
            String mobile = getUserInput("Please enter your mobile number: ");
            RealCustomer realCustomer = new RealCustomer(name, phone);
            realCustomer.setFamily(family);
            realCustomer.setMobilePhoneNumber(mobile);
            customerService.addCustomer(realCustomer);
        } else if (choice.equals("2")) {
            String name = getUserInput("Please enter your name: ");
            String companyName = getUserInput("Please enter your company name: ");
            String phone = getUserInput("Please enter your phone number: ");
            String fax = getUserInput("Please enter your fax: ");
            LegalCustomer legalCustomer = new LegalCustomer(name, phone);
            legalCustomer.setCompanyName(companyName);
            legalCustomer.setFax(fax);
            customerService.addCustomer(legalCustomer);
        }else {
            System.out.println("Invalid choice");
        }
    }

    private void printMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("0. Exit");
        System.out.println("1. Add new customers");
        System.out.println("2. Show all customers");
        System.out.println("3. Search customer by name");
        System.out.println("4. Search customer by family");
        System.out.println("Please choose one of the  above options:");
    }

    private String getUserInput(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
