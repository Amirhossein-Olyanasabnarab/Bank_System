package dk.amir.view.component;

import dk.amir.model.Customer;

public class LegalCustomerUI extends AbstractCustomerUI{
    public LegalCustomerUI(){
        super();
    }
    @Override
    protected Customer additionalGenerateCustomer(String name, String phone, String email) {
        return null;
    }

    @Override
    public void editCustomer(Customer customer) {

    }
}
