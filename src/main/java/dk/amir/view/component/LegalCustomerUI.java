package dk.amir.view.component;

import dk.amir.model.Customer;
import dk.amir.model.LegalCustomer;

import java.util.function.Function;

public class LegalCustomerUI extends AbstractCustomerUI{
    public LegalCustomerUI(){
        super();
    }
    @Override
    protected Customer additionalGenerateCustomer(String name, String phone, String email) {
        String industry = scannerWrapper.getMessage("Please enter industry:", Function.identity());
        LegalCustomer legalCustomer = new LegalCustomer(name, phone, email);
        legalCustomer.setIndustry(industry);
        return legalCustomer;
    }

    @Override
    public void editCustomer(Customer customer) {
        LegalCustomer legalCustomer = (LegalCustomer) customer;
        String name = scannerWrapper.getMessage("Please enter new name:", Function.identity());
        legalCustomer.setName(name);
        String phone = scannerWrapper.getMessage("Please enter new phone:", Function.identity());
        legalCustomer.setPhoneNumber(phone);
        String email = scannerWrapper.getMessage("Please enter new email:", Function.identity());
        legalCustomer.setEmail(email);
        String industry = scannerWrapper.getMessage("Please enter industry:", Function.identity());
        legalCustomer.setIndustry(industry);
    }
}
