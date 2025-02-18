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
    }

    @Override
    public void editCustomer(Customer customer) {

    }
}
