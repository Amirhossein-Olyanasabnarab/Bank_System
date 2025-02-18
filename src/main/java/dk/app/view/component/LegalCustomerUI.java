package dk.app.view.component;

import dk.app.model.Customer;
import dk.app.model.LegalCustomer;

import java.util.Scanner;

public class LegalCustomerUI extends AbstractCustomerUI{
    public LegalCustomerUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Customer generateCustomer() {
        String name = getUserInput("Please enter customer's name: ");
        String companyName = getUserInput("Please enter customer's company name: ");
        String phone = getUserInput("Please enter customer's phone: ");
        String fax = getUserInput("Please enter customer's fax: ");
        LegalCustomer legalCustomer = new LegalCustomer(name, phone);
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setFax(fax);
        return legalCustomer;
    }

    @Override
    public void editCustomer(Customer customer) {

    }
}
