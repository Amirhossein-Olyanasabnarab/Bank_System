package dk.amir.view.component;

import dk.amir.model.Customer;
import dk.amir.model.RealCustomer;

import java.util.function.Function;

public class RealCustomerUI extends AbstractCustomerUI{
    public RealCustomerUI(){
        super();
    }
    @Override
    protected Customer additionalGenerateCustomer(String name, String phone, String email) {
        String family = scannerWrapper.getMessage("Please enter family:", Function.identity());
        RealCustomer realCustomer = new RealCustomer(name, phone, email);
        realCustomer.setFamily(family);
        return realCustomer;
    }

    @Override
    public void editCustomer(Customer customer) {
        RealCustomer realCustomer = (RealCustomer) customer;
        String name = scannerWrapper.getMessage("Please enter new name:", Function.identity());
        realCustomer.setName(name);
        String phone = scannerWrapper.getMessage("Please enter new phone:", Function.identity());
        realCustomer.setPhoneNumber(phone);
        String email = scannerWrapper.getMessage("Please enter new email:", Function.identity());
        realCustomer.setEmail(email);
        String family = scannerWrapper.getMessage("Please enter family:", Function.identity());
        realCustomer.setFamily(family);
    }
}
