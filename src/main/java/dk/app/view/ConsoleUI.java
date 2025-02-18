package dk.app.view;

import dk.app.model.Customer;
import dk.app.model.LegalCustomer;
import dk.app.model.RealCustomer;
import dk.app.service.CustomerService;
import dk.app.view.component.AbstractCustomerUI;
import dk.app.view.component.LegalCustomerUI;
import dk.app.view.component.RealCustomerUI;

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
                case 5:
                    editCustomerById();
                    break;
                case 6:
                    deleteCustomerById();
                    break;
                case 7:
                    showAllDeletedCustomers();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice != 0);
    }

    private void showAllDeletedCustomers() {
        List<Customer> deletedCustomers = customerService.getAllDeletedCustomers();
        if(deletedCustomers.isEmpty()){
            System.out.println("No customers found");
        }
        deletedCustomers.forEach(System.out::println);
    }

    private void deleteCustomerById() {
        Integer id = Integer.parseInt(getUserInput("Please enter the id of the customer"));
        customerService.deleteCustomer(id);
    }

    private void editCustomerById() {
        String id = getUserInput("Enter ID: ");
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        if (customer == null) {
            System.out.println("Customer not found");
        }
        System.out.println(customer);
        if (customer instanceof RealCustomer realCustomer){
            String newName = getUserInput("Enter new name: ");
            realCustomer.setName(newName);
            String newFamily = getUserInput("Enter new family: ");
            realCustomer.setFamily(newFamily);
            String newPhone = getUserInput("Enter new phone: ");
            realCustomer.setMobilePhoneNumber(newPhone);
            String newMobile = getUserInput("Enter new mobile: ");
            realCustomer.setMobilePhoneNumber(newMobile);
        }else if (customer instanceof LegalCustomer legalCustomer){
            String newName = getUserInput("Enter new name: ");
            legalCustomer.setName(newName);
            String newCompany = getUserInput("Enter new company: ");
            legalCustomer.setCompanyName(newCompany);
            String newPhone = getUserInput("Enter new phone: ");
            legalCustomer.setPhoneNumber(newPhone);
            String newFax = getUserInput("Enter new fax: ");
            legalCustomer.setFax(newFax);
        }
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

        AbstractCustomerUI customerUI;

        if (choice.equals("1")) {
            customerUI = new RealCustomerUI(scanner);
        }else {
            customerUI = new LegalCustomerUI(scanner);
        }
        Customer customer = customerUI.generateCustomer();
        customerService.addCustomer(customer);
    }

    private void printMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("0. Exit");
        System.out.println("1. Add new customers");
        System.out.println("2. Show all customers");
        System.out.println("3. Search customer by name");
        System.out.println("4. Search customer by family");
        System.out.println("5. Edit customer by id");
        System.out.println("6. Delete customer by id");
        System.out.println("7. Show all deleted customers");
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
