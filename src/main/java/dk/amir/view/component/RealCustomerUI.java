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

    }
}
