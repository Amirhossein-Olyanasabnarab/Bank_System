package dk.app.view.component;

import dk.app.model.Customer;
import dk.app.model.RealCustomer;

import java.util.Scanner;

public class RealCustomerUI extends AbstractCustomerUI{
    public RealCustomerUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Customer generateCustomer() {
        String name = getUserInput("Please enter customer's name: ");
        String family = getUserInput("Please enter customer's family: ");
        String phone = getUserInput("Please enter customer's phone: ");
        String mobile = getUserInput("Please enter customer's mobile: ");
        RealCustomer realCustomer = new RealCustomer(name, phone);
        realCustomer.setFamily(family);
        realCustomer.setMobilePhoneNumber(mobile);
        return realCustomer;
    }

    @Override
    public void editCustomer(Customer customer) {
        RealCustomer realCustomer = (RealCustomer) customer;
        String newName = getUserInput("Please enter customer's name: ");
        String newFamily = getUserInput("Please enter customer's family: ");
        String newPhone = getUserInput("Please enter customer's phone: ");
        String newMobile = getUserInput("Please enter customer's mobile: ");
        realCustomer.setName(newName);
        realCustomer.setFamily(newFamily);
        realCustomer.setMobilePhoneNumber(newMobile);
        realCustomer.setPhoneNumber(newPhone);
    }
}
